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

//    public static ArrayList<Author> loadAutors(ArrayList<Author> authors) {
//        String sql = "Select author_name,id from author";
//        Integer x=0;
//        try {
//            Connection connection = JDBCConnector.createConnection();
//            PreparedStatement statment = connection.prepareStatement(sql);
//            ResultSet resultSet = statment.executeQuery();
//            if (resultSet != null) {
//                while (resultSet.next()) {
//                    Author tempAuthor = new Author();
//                    tempAuthor.setBookAuthor(resultSet.getString("author_name"));
//                    tempAuthor.setAuthorId(resultSet.getInt("id"));
//                    authors.add(tempAuthor);
//                    x++;
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Ошибка выполнения sql.....");
//            e.printStackTrace();
//        }
//        return authors;
//    }
//
//    public static ArrayList<TableLine> fetchingData(ArrayList<TableLine> inputTable, String tableName) {
//        String sql = "";
//        int x = 0;
//        try {
//            if (tableName == "author") sql = "Select author_name,id from author";
//            else sql = "Select book_name,author_id from book";
//
//            Connection connection = JDBCConnector.createConnection();
//            PreparedStatement statment = connection.prepareStatement(sql);
//            ResultSet resultSet = statment.executeQuery();
//            if (resultSet != null) {
//                while (resultSet.next()) {
//                    TableLine tableLine = new TableLine();
//                    if (tableName == "author") {
//                        tableLine.setNameField(resultSet.getString("author_name"));
//                        tableLine.setIdField(resultSet.getInt("id"));
//                    } else {
//                        tableLine.setNameField(resultSet.getString("book_name"));
//                        tableLine.setIdField(resultSet.getInt("author_id"));
//                    }
//                    inputTable.add(tableLine);
//                    x++;
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Ошибка выполнения sql.....");
//            e.printStackTrace();
//        }
//        return inputTable;
//    }

}
