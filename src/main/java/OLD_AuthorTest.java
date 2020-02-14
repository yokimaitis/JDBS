import java.util.ArrayList;

public class OLD_AuthorTest {
    private ArrayList<TableLine> authorTable;

    public void setAuthorTable(ArrayList<TableLine> authorTable) {
        this.authorTable = authorTable;
    }

    public ArrayList<TableLine> getAuthorTable() {
        return authorTable;
    }

    public OLD_AuthorTest() {
        authorTable = new ArrayList<>();
        Table table = new Table();
        authorTable = table.getData(table.createTable(),"author");
    }
}
