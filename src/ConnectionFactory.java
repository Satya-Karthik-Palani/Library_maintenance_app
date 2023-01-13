import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Karthik@2";
    private static final String URL = "jdbc:mysql://localhost:3306/Library";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Properties connectionProperties = new Properties();
            connectionProperties.put("user", USERNAME);
            connectionProperties.put("password", PASSWORD);
            con = DriverManager.getConnection(URL, connectionProperties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
