import view.LoginFrame;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
try {  Connection conn = DriverManager.getConnection("jdbc:sqlite:meubanco.db");
            new LoginFrame(conn).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

  
