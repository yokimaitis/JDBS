import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
 //       ArrayList<Author> authors;
 //       authors = new Library().getAuthors();

        String a = new Scanner(System.in).nextLine();
        Author author = new Library().getBooks(a);


        for (int i = 0; i < author.getBooks().size() ; i++) {
            System.out.println(author.getBooks().get(i).getBookName());
        }

/////////////////   OLD   //////////////////

//        Integer input=0;
//
//        System.out.println("Библиотека книг :)\n");
//        System.out.println("Введите 1 - Для просмотра авторов в библиотеке.");
//        System.out.println("Введите 2 - Для просмотра книг автора.");
//        System.out.println("Введите 3 - Для добавления Автора.");
//        System.out.println("Введите 4 - Для добавления Книги.\n");
//
//        switch (input){
//            case 1: {DataBase.printAutors();break;}
//            case 2: {DataBase.printBooks();break;}
//            case 3: {DataBase.addAutor();break;}
//            case 4: {DataBase.addBook();break;}
//        }

//////////////////////////////////////////


    }
}
