import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnector {
    public static final String DRIVER_NAME = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost/postgres";
    public static final String USER_NAME = "postgres";
    public static final String PASSWORD = "12345";
    public static final String EMPTY = "";
    public static final String LINE = "\n";

    static {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }

    public static void closeResultSet(ResultSet set) {
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
