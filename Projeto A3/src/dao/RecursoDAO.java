package dao;

import model.Interesse;
import model.Recurso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecursoDAO {

    public void inserir(Recurso recurso) throws SQLException {
        String sql = "INSERT INTO recursos (titulo, autor, categoria, usuario_id, url, descricao) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, recurso.getTitulo());
            stmt.setString(2, recurso.getAutor());
            stmt.setString(3, recurso.getCategoria().name());
            stmt.setInt(4, recurso.getUsuarioId());
            stmt.setString(5, recurso.getUrl());
            stmt.setString(6, recurso.getDescricao());
            stmt.executeUpdate();
        }
    }

    public List<Recurso> listarPorCategoria(Interesse categoria) throws SQLException {
        List<Recurso> lista = new ArrayList<>();
        String sql = "SELECT * FROM recursos WHERE categoria = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.name());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Recurso r = new Recurso(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    Interesse.valueOf(rs.getString("categoria")),
                    rs.getInt("usuario_id"),
                    rs.getString("url"),
                    rs.getString("descricao")
                );
                lista.add(r);
            }
        }
        return lista;
    }

    public List<Recurso> listarTodos() throws SQLException {
        List<Recurso> lista = new ArrayList<>();
        String sql = "SELECT * FROM recursos";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Recurso r = new Recurso(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    Interesse.valueOf(rs.getString("categoria")),
                    rs.getInt("usuario_id"),
                    rs.getString("url"),
                    rs.getString("descricao")
                );
                lista.add(r);
            }
        }
        return lista;
    }
}
