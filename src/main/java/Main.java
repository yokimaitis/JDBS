import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = JDBCConnector.createConnection();
        PreparedStatement statment = connection.prepareStatement("CREATE TABLE GOODS (\n" +
                "   MODEL        SMALLINT NOT NULL UNIQUE,\n" +
                "   NAME           CHAR(10) NOT NULL,\n" +
                "   ITEMID          INTEGER NOT NULL, CONSTRAINT MOD_UNIQUE\n" +
                "UNIQUE (NAME, ITEMID));");
        ResultSet resultSet = statment.executeQuery();
        if (resultSet!=null) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));

            }
        }




    }
}
