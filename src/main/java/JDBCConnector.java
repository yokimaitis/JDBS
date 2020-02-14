import java.sql.*;
import java.util.ArrayList;

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

    public static ArrayList<TableLine> fetchingData(ArrayList<TableLine> inputTable){
        int x=0;
        try {
            Connection connection = JDBCConnector.createConnection();
            PreparedStatement statment = connection.prepareStatement("Select author_name,id from author");
            ResultSet resultSet = statment.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    TableLine tb = new TableLine();
                    tb.setNameField(resultSet.getString("author_name"));
                    tb.setIdField(resultSet.getInt("id"));
                    inputTable.add(tb);
                    x++;
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка поиска авторов.....");
            e.printStackTrace();
        }
        return inputTable;
    }

}
