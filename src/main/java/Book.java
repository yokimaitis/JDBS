public class Book {
    private String bookName;
    private Integer bookId;
    private Integer bookYear;

    public String getBookName() {
        return bookName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public Integer getBookYear() {
        return bookYear;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setBookYear(Integer bookYear) {
        this.bookYear = bookYear;
    }

    public Book() {
    }

    public Book(String bookName, Integer bookId) {
        this.bookName = bookName;
        this.bookId = bookId;
    }
}
