
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

    private static Connection connection = null;

    public static Connection getConnection() {  // cria conexao com o banco de dados
        if (connection != null) {
            return connection;
        } else {
            try {
                Properties prop = new Properties();

                String user = "postgres";
                String password = "postgres";
                Class.forName("org.postgresql.Driver");// drive para o postgres
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbmediando", user, password);// Faz a conexao com o postgres
                System.out.print("Conexão efetuada com sucesso...\n");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;

        }

    }
}
