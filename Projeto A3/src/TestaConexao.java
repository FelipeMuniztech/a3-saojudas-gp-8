import java.sql.Connection;
import util.Conexao;

public class TestaConexao {
    public static void main(String[] args) {
        DataBase.getConnection();
        DataBase.closeConnection();
    }
}

