import java.util.ArrayList;

public class Book {
    private  ArrayList<TableLine> bookTable;

    public void BookTableCreate() {
        Table table = new Table();
        this.bookTable = table.getData(table.createTable(),"book");

    }
}
