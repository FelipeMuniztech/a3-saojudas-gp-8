package util; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
private static final String URL = "jdbc:mysql://127.0.0.1:3306/a3_drytech";
private static final String USUARIO = "root";
private static final String SENHA = "07132406";

public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
}




