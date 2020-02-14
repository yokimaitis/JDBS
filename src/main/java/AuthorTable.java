import java.util.ArrayList;

public class AuthorTable {

    public static void AuthorTableCreate() {
        ArrayList<TableLine> authorTable = new ArrayList<>();
        Table table = new Table();
        authorTable = table.getData(table.createTable(),"author");

        for (int k = 0; k < authorTable.size() ; k++) {
            System.out.println(authorTable.get(k).getNameField());
        }
    }
}
