import java.util.ArrayList;
import java.util.List;

public class Table {

   ArrayList<TableLine> getData(ArrayList<TableLine> inputTable, String tableName){
        return JDBCConnector.fetchingData(inputTable);
   }

   public ArrayList<TableLine> createTable(){
       ArrayList<TableLine> table = new ArrayList<>();
       return table;
   }
}
