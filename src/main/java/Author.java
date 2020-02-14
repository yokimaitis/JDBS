import java.util.ArrayList;

public class Author {
    private String bookAuthor;
    private Integer authorId;
    private ArrayList<Book> books;

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

}
