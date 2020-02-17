import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public ArrayList<Author> getAuthors() {
        ArrayList<Author> authors = new ArrayList<>();
        String sql = "Select author_name,id from author";
        Integer x = 0;
        try {
            Connection connection = JDBCConnector.createConnection();
            PreparedStatement statment = connection.prepareStatement(sql);
            ResultSet resultSet = statment.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    Author tempAuthor = new Author();
                    tempAuthor.setBookAuthor(resultSet.getString("author_name"));
                    tempAuthor.setAuthorId(resultSet.getInt("id"));
                    authors.add(tempAuthor);
                    x++;
                }
            }
            connection.close();
            statment.close();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения sql.....");
            e.printStackTrace();
        }
        return authors;
    }

    public Author getAuthor(Integer id) {
        Author author = null;
        String sql = "Select * from author Where id=" + id;
        try {
            Connection connection = JDBCConnector.createConnection();
            PreparedStatement statment = connection.prepareStatement(sql);
            ResultSet resultSet = statment.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    author = new Author(resultSet.getString("author_name"), id);
                }
            }
            connection.close();
            statment.close();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения sql.....");
            e.printStackTrace();
        }

        return author;
    }

    public Author getAuthor(String name) {
        Author author = null;
        String sql = "Select * from author Where author_name='" + name + "'";
        try {
            Connection connection = JDBCConnector.createConnection();
            PreparedStatement statment = connection.prepareStatement(sql);
            ResultSet resultSet = statment.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    author = new Author(name, resultSet.getInt("id"));
                }
            }
            connection.close();
            statment.close();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения sql.....");
            e.printStackTrace();
        }
        return author;
    }

    public Author getBooks(String authorName) {
        ArrayList<Book> books = new ArrayList<>();
        Author author = getAuthor(authorName);
        String sql = "Select * from book Where author_id=" + author.getAuthorId();
        Integer x = 0;
        try {
            Connection connection = JDBCConnector.createConnection();
            PreparedStatement statment = connection.prepareStatement(sql);
            ResultSet resultSet = statment.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    Book book = new Book(resultSet.getString("book_name"), resultSet.getInt("author_id"));
                    books.add(book);
                }
            }
            connection.close();
            statment.close();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения sql.....");
            e.printStackTrace();
        }
        author.setBooks(books);
        return author;
    }

    public void addAuthor() {
        String inputAuthor = "";
        Author author = new Author();
        System.out.println("Добавление Автора...");
        System.out.println("");
        System.out.println("Введите автора книги:");
        inputAuthor = new Scanner(System.in).nextLine();

        try {
            author = getAuthor(inputAuthor);
            if (author == null) {
                Connection connection = JDBCConnector.createConnection();
                PreparedStatement statment = connection.prepareStatement("INSERT INTO author (author_name) VALUES ('" + inputAuthor + "');");
                if (statment.executeUpdate() > 0) System.out.println("Автор " + inputAuthor + " добавлен..");
                connection.close();
                statment.close();
            } else {
                System.out.println("Такой автор уже есть в базе.");
                return;
            }
        } catch (SQLException e) {
            System.out.println("Ошибка добавления автора.....");
            e.printStackTrace();
        }
    }

    public void addBook() {
        String inputAuthor = "";
        String inputBook = "";
        Author author = new Author();
        System.out.println("Добавление Книги...");
        System.out.println("");
        System.out.println("Введите автора книги:");
        inputAuthor = new Scanner(System.in).nextLine();
        try {
            author = getAuthor(inputAuthor);
            if (author != null) {
                System.out.println("Введите название книги");
                inputBook = new Scanner(System.in).nextLine();
                Connection connection = JDBCConnector.createConnection();
                PreparedStatement statment = connection.prepareStatement("INSERT INTO book (book_name,author_id) VALUES ('" + inputBook + "'," + author.getAuthorId() + ");");
                statment.executeUpdate();
                System.out.println("Книга добавлена....");
                connection.close();
                statment.close();
            } else {
                System.out.println("Такого автора нету в базе....");
                return;
            }

        } catch (SQLException e) {
            System.out.println("Ошибка добавления книги.....");
            e.printStackTrace();
        }
    }
}
