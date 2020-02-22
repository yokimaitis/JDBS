import org.postgresql.core.SqlCommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public ArrayList<Author> getAuthors() {
        ArrayList<Author> authors = new ArrayList<>();
        ResultSet resultSet;
        String sql = "Select author_name,id from author";
        Integer x = 0;
        try {
            resultSet = sqlResultSet(sql);
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
        ResultSet resultSet;
        String sql = "Select * from author Where id=" + id;
        try {
            resultSet = sqlResultSet(sql);
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

    public Author getAuthor(String name) throws SQLException {
        Author author = null;
        ResultSet resultSet;
        String sql = "Select * from author Where author_name='" + name + "'";
        resultSet = sqlResultSet(sql);
        if (resultSet != null) {
            while (resultSet.next()) {
                author = new Author(name, resultSet.getInt("id"));
            }
        }
        return author;
    }

    public Author getAuthorAndBooks(String authorName) {
        ArrayList<Book> books = new ArrayList<>();
        Author author = null;
        ResultSet resultSet;
        try {
            author = getAuthor(authorName);
            String sql = "Select * from book Where author_id=" + author.getAuthorId();
            resultSet = sqlResultSet(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    Book book = new Book(resultSet.getString("book_name"), resultSet.getInt("id"));
                    books.add(book);
                }
            }
            author.setBooks(books);
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения sql.....");
        }
        return author;
    }

    public void addAuthor() {
        String inputAuthor = "";
        Author author;
        String sql;
        System.out.println("Добавление Автора...");
        System.out.println("");
        System.out.println("Введите автора книги:");
        inputAuthor = new Scanner(System.in).nextLine();
        try {
            author = getAuthor(inputAuthor);
            if (author == null) {
                sql = "INSERT INTO author (author_name) VALUES ('" + inputAuthor + "');";
                if (sqlExecuteUpdate(sql) > 0) System.out.println("Автор " + inputAuthor + " добавлен..");
            } else {
                System.out.println("Такой автор уже есть в базе.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка добавления автора.....");
        }
    }

    public void addBook() {
        String inputAuthor = "";
        String inputBook = "";
        Author author;
        Author authorAndBooks;
        String sql;
        System.out.println("Добавление Книги...");
        System.out.println("");
        System.out.println("Введите автора книги:");
        inputAuthor = new Scanner(System.in).nextLine();
        try {
            author = getAuthor(inputAuthor);
            if (author != null) {
                System.out.println("Введите название книги");
                inputBook = new Scanner(System.in).nextLine();
                sql = "INSERT INTO book (book_name,author_id) VALUES ('" + inputBook + "'," + author.getAuthorId() + ");";
                sqlExecuteUpdate(sql);
                System.out.println("Книга добавлена....\n");
            } else {
                System.out.println("Такого автора нету в базе....");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка добавления книги.....");
        }
        authorAndBooks = getAuthorAndBooks(inputAuthor);
        System.out.println("Книг автора "+authorAndBooks.getBooks().size());
        writeBookAuthor(authorAndBooks.getAuthorId(),authorAndBooks.returnBookID(inputBook));

    }

    public void writeBookAuthor(Integer author_id, Integer book_id){
        String sql = "INSERT INTO bookauthor (author_id,book_id) VALUES ("+author_id+","+book_id+");";
        sqlExecuteUpdate(sql);
    }

    public ResultSet sqlResultSet(String input) {
        ResultSet outSet = null;
        try {
            Connection connection = JDBCConnector.createConnection();
            PreparedStatement statment = connection.prepareStatement(input);
            outSet = statment.executeQuery();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка запроса sql....");
        }
        return outSet;
    }

    public Integer sqlExecuteUpdate(String input) {
        Integer outValue = 0;
        try {
            Connection connection = JDBCConnector.createConnection();
            PreparedStatement statment = connection.prepareStatement(input);
            outValue = statment.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения executeUpdate .... ");
        }
        return outValue;
    }

}
