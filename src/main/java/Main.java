import java.lang.invoke.SwitchPoint;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer input=0;
        System.out.println("Библиотека книг :)\n");
        System.out.println("Введите 1 - Для просмотра авторов в библиотеке.");
        System.out.println("Введите 2 - Для просмотра книг автора.");
        System.out.println("Введите 3 - Для добавления Автора.");
        System.out.println("Введите 4 - Для добавления Книги.\n");
        input = Integer.valueOf(new Scanner(System.in).nextLine());

       switch (input){
            case 1: {DataBase.printAutors();break;}
            case 2: {DataBase.printBooks();break;}
            case 3: {DataBase.addAutor();break;}
            case 4: {DataBase.addBook();break;}

        }



//        Connection connection = JDBCConnector.createConnection();
//        PreparedStatement statment = connection.prepareStatement("Select * from autor");
//        ResultSet resultSet = statment.executeQuery();
//
//        if (resultSet!=null) {
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("autor_name"));
//
//            }
//        }
//


    }
}
