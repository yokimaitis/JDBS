import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения sql.....");
            e.printStackTrace();
        }

        return author;
    }

    public Author getAuthor(String name) {
        Author author = null;
        String sql = "Select * from author Where author_name='" + name +"'";
        try {
            Connection connection = JDBCConnector.createConnection();
            PreparedStatement statment = connection.prepareStatement(sql);
            ResultSet resultSet = statment.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    author = new Author(name,resultSet.getInt("id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения sql.....");
            e.printStackTrace();
        }
        return author;
    }

    public Author getBooks(String authorName) {
        ArrayList<Book> books = new ArrayList<>();
        Author author = getAuthor(authorName);
        String sql = "Select * from book Where author_id="+author.getAuthorId();
        Integer x = 0;
        try {
            Connection connection = JDBCConnector.createConnection();
            PreparedStatement statment = connection.prepareStatement(sql);
            ResultSet resultSet = statment.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    Book book = new Book(resultSet.getString("book_name"),resultSet.getInt("author_id"));
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения sql.....");
            e.printStackTrace();
        }
        author.setBooks(books);
        return author;
    }
}
