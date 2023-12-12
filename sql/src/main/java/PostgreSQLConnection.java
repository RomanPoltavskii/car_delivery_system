import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreSQLConnection {
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "1111";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DRIVER = "org.postgresql.Driver";
    private Connection connection;
    public PostgreSQLConnection() {
        this.connection = createConnectiob();
    }
    private Connection createConnectiob() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void execute(String quaery) throws SQLException {
        connection.createStatement().execute(quaery);
    }
    public ResultSet executeQuaery(String quaery) throws SQLException {
        return connection.createStatement().executeQuery(quaery);
    }
}
