package dao;

import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO(Connection conn){
        this.conn = conn;
    }

    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
            String sql  = "SELECT * FROM usuarios";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    usuarios.add(new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email");
                    

                }
    }

}
