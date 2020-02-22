import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        boolean outCommand = false;

        while (outCommand != true) {
            System.out.println("Библиотека книг :)\n");
            System.out.println("Введите 1 - Для просмотра авторов в библиотеке.");
            System.out.println("Введите 2 - Для просмотра книг автора.");
            System.out.println("Введите 3 - Для добавления Автора.");
            System.out.println("Введите 4 - Для добавления Книги.");
            System.out.println("Введите 5 - для выхода.\n");

            Integer input = 0;
            input = Integer.valueOf(new Scanner(System.in).nextLine());
            switch (input) {
                case 1: {
                    ArrayList<Author> authors = new Library().getAuthors();
                    for (int i = 0; i < authors.size(); i++) {
                        System.out.println(authors.get(i).getBookAuthor());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Введите автора книги....");
                    String a = new Scanner(System.in).nextLine();
                    Author author;
                    try {
                        author = new Library().getAuthorAndBooks(a);
                        for (int i = 0; i < author.getBooks().size(); i++) {
                            System.out.println(author.getBooks().get(i).getBookName());
                        }
                    } catch (Exception e) {
                        System.out.println("Автор не найден....");
                    }
                    break;
                }
                case 3: {
                    new Library().addAuthor();
                    break;
                }
                case 4: {
                    new Library().addBook();
                    break;
                }
                case 5: {
                    outCommand = true;
                    break;
                }
            }
        }
    }
}
