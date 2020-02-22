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

    public Author(String bookAuthor, Integer authorId) {
        this.bookAuthor = bookAuthor;
        this.authorId = authorId;
    }

    public Author() {
    }

    public Integer returnBookID(String input) {
        int out = 0;
        for (int i = 0; i < books.size(); i++) {
            if (input.equals(books.get(i).getBookName())) {
                out = books.get(i).getBookId();
                break;
            }
        }
        return out;
    }
}
