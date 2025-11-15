import java.sql.Connection;
import util.Conexao; //ta importando errado aq sipa ne

public class TestaConexao {
    public static void main(String[] args) {
        DataBase.getConnection();
        DataBase.closeConnection();
    }
}

