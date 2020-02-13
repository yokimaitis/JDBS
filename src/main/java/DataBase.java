import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DataBase {

    public static void printAutors() {
        try {
            Connection connection = JDBCConnector.createConnection();
            PreparedStatement statment = connection.prepareStatement("Select autor_name from autor");
            ResultSet resultSet = statment.executeQuery();
            System.out.println("Авторы в базе: \n");
            if (resultSet != null) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("autor_name"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка поиска авторов.....");
            e.printStackTrace();
        }
    }

    public static void printBooks() {
        String inputAutor = "";
        ;
        Integer autorId = 0;
        System.out.println("Введите автора книги:");
        inputAutor = new Scanner(System.in).nextLine();
        try {
            Connection connection = JDBCConnector.createConnection();

            PreparedStatement statment = connection.prepareStatement("Select id from autor WHERE autor_name='" + inputAutor + "'");
            ResultSet resultSet = statment.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    autorId = resultSet.getInt("id");
                }
                if (autorId > 0) {
                    statment = connection.prepareStatement("Select book_name from book WHERE autor_id=" + autorId);
                    resultSet = statment.executeQuery();
                    if (resultSet != null) {
                        System.out.println("Найденные книги автора " + inputAutor + ": ");
                        while (resultSet.next()) {
                            System.out.println(resultSet.getString("book_name"));
                        }
                    }
                } else {
                    System.out.println("Такого автора нету в базе....");
                    return;
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка поиска книг.....");
            e.printStackTrace();
        }
    }

    public static void addAutor() {
        String inputAutor = "";
        Integer autorId = 0;
        System.out.println("Добавление Автора...");
        System.out.println("");
        System.out.println("Введите автора книги:");
        inputAutor = new Scanner(System.in).nextLine();

        try {
            Connection connection = JDBCConnector.createConnection();
            PreparedStatement statment = connection.prepareStatement("Select id from autor WHERE autor_name='" + inputAutor + "'");
            ResultSet resultSet = statment.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    autorId = resultSet.getInt("id");
                }
                if (autorId == 0) {
                    connection = JDBCConnector.createConnection();
                    statment = connection.prepareStatement("INSERT INTO autor (autor_name) VALUES ('" + inputAutor + "');");
                    if (statment.executeUpdate() > 0) System.out.println("Автор " + inputAutor + " добавлен..");
                } else {
                    System.out.println("Такой автор уже есть в базе.");
                    return;
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка добавления автора.....");
            e.printStackTrace();
        }
    }


    public static void addBook() {
        String inputAutor = "";
        String inputBook = "";
        Integer autorId = 0;
        System.out.println("Добавление Книги...");
        System.out.println("");
        System.out.println("Введите автора книги:");
        inputAutor = new Scanner(System.in).nextLine();
        try {
            Connection connection = JDBCConnector.createConnection();

            PreparedStatement statment = connection.prepareStatement("Select id from autor WHERE autor_name='" + inputAutor + "'");
            ResultSet resultSet = statment.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    autorId = resultSet.getInt("id");
                }
                if (autorId > 0) {
                    System.out.println("Введите название книги");
                    inputBook = new Scanner(System.in).nextLine();
                    statment = connection.prepareStatement("INSERT INTO book (book_name,autor_id) VALUES ('" + inputBook + "'," + autorId + ");");
                    statment.executeUpdate();
                    System.out.println("Книга добавлена....");
                } else {
                    System.out.println("Такого автора нету в базе....");
                    return;
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка добавления книги.....");
            e.printStackTrace();
        }
    }
}
