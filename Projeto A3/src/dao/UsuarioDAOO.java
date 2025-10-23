package dao;

import model.Usuario;
import model.Interesse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn){
        this.conn = conn;
    }

//metodo listar
    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
            String sql  = "SELECT * FROM usuarios";

           try( Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
               while (rs.next()) {
                   //novo modelo de usuario
                   Usuario usuario = new Usuario(
                           rs.getInt("id"),
                           rs.getString("nome"),
                           rs.getInt("idade"),
                           rs.getString("tipo")
                   );
                   usuario.setAtivo(rs.getBoolean("ativo"));
               //carrega os interesses
                    carregarInteressesUsuario(usuario);
               //adiciona usuario na lista
                    usuarios.add(usuario);

               }

           }

        return usuarios;
    }

    //metodo buscas por id
    public Usuario buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, nome, idade, tipo, ativo FROM usuarios WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id); //parametros

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getInt("idade"),
                            rs.getString("tipo")
                    );
                    usuario.setAtivo(rs.getBoolean("ativo"));
                    carregarInteressesUsuario(usuario);
                    return usuario;
                }
            }
        }
        return null;
    }
    //metodo cadastrar usuario
    public void cadastrar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, idade, tipo, ativo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, usuario.getNome());
            stmt.setInt(2, usuario.getIdade());
            stmt.setString(3, usuario.getTipo());
            stmt.setBoolean(4, usuario.isAtivo());

            stmt.executeUpdate();

            //pegar id gerado
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                usuario.setId(rs.getInt(1));
            }
            cadastrarInteressesUsuario(usuario);
        }
    }
    //metodo atualizar

    public void atualizar (Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nome = ?, idade = ?, tipo = ?, ativo = ?, ativo = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setInt(2, usuario.getIdade());
            stmt.setString(3, usuario.getTipo());
            stmt.setBoolean(4, usuario.isAtivo());
            stmt.setInt(5, usuario.getId());

            stmt.executeUpdate();

            //atualizar interesses
            removerInteressesUsuario(usuario.getId());
            cadastrarInteressesUsuario(usuario);
        }
    }
    //mnetodo ativar
    public void ativar (int id) throws SQLException {
        String sql = "UPDATE usuarios SET ativo = true WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    //metodo inativar
    public void inativar(int id) throws SQLException {
        String sql = "UPDATE usuarios SET ativo = false WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    //metodo carregar interesses
        private void carregarInteressesUsuario(Usuario usuario) throws SQLException {
        String sql = "SELECT interesse FROM usuario_interesses WHERE usuario_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, usuario.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                String interesseStr = rs.getString("interesse");
                Interesse interesse = Interesse.valueOf(interesseStr);
                usuario.adicionarInteresse(interesse);
            }
        }
    }
    //metodo cadastrar interesse
    private void cadastrarInteressesUsuario (Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario_interesses WHERE usuario_id, interesse VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        for (Interesse interesse : usuario.getInteresses()){
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, interesse.name());
            stmt.addBatch();
            }
        stmt.executeBatch();
        }
    }
    //metodo remover interesse
    private void removerInteressesUsuario (int usuarioId) throws SQLException {
        String sql = "DELETE FROM usuario_interesses WHERE usuaio_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, usuarioId);
            stmt.executeUpdate();
        }
    }

}
