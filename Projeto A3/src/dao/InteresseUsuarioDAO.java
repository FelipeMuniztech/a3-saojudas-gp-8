package dao;

import model.Interesse;
import model.InteresseUsuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InteresseUsuarioDAO {

    public void inserir(InteresseUsuario iu) throws SQLException {
        String sql = "INSERT INTO usuario_interesses (usuario_id, categoria_id) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, iu.getUsuarioId());
            stmt.setInt(2, iu.getCategoriaId());
            stmt.executeUpdate();
        }
    }

    public List<Integer> buscarPorUsuario(int usuarioId) throws SQLException {
        List<Integer> categorias = new ArrayList<>();
        String sql = "SELECT categoria_id FROM usuario_interesses WHERE usuario_id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                categorias.add(rs.getInt("categoria_id"));
            }
        }
        return categorias;
    }
}
