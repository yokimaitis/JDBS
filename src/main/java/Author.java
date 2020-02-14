import java.util.ArrayList;

public class Author {
    private ArrayList<TableLine> authorTable;

    public void setAuthorTable(ArrayList<TableLine> authorTable) {
        this.authorTable = authorTable;
    }

    public ArrayList<TableLine> getAuthorTable() {
        return authorTable;
    }

    public Author() {
        authorTable = new ArrayList<>();
        Table table = new Table();
        authorTable = table.getData(table.createTable(),"author");
    }
}
