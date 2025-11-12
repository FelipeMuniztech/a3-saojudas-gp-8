import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
  private static final String USER = "root";
private static final String PASSWORD = "root";
private static final String URL = "jdbc:mysql://localhost:3306/sistema_curadoria?useSSL=false&serverTimezone=UTC";


    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Conexão bem-sucedida com o banco de dados!");
            } catch (SQLException e) {
                System.out.println("❌ Erro na conexão com o banco de dados:");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("🔒 Conexão encerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
