import com.perennialsys.entity.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import static jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.S;

public class Main {
    static void menu() {
        System.out.println("1-Add new  book ");
        System.out.println("2-Display all book");
        System.out.println("3-Request new book");
        System.out.println("4-Add new user");
        System.out.println("0-Exit");
    }

    public static void main(String[] args) {
        int opt;
        ArrayList<Book> listOfBooks = new ArrayList<>();
              Scanner scanner = new Scanner(System.in);

        do {
            Book book = new Book();
            menu();
            opt = scanner.nextInt();
            switch (opt) {


                case 1:
                    System.out.println("Enter the book number");
                    book.setIsbn(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter the book name");
                    book.setName(scanner.nextLine());
                    scanner.nextLine();
                    Set<String>set = new HashSet<>();
                    System.out.println("Enter the author name ");
                    set.add(scanner.nextLine());
                    book.setDate(new Date());
                     book.setAuthors(set);
                     int hashcode =book.hashCode();
                     System.out.println("Hashcode of book"+hashcode);

                    book.addNewBook(book);
                    listOfBooks.add(book);
                    break;
                case 2:
                    book.displayBooks(listOfBooks);
                    break;
                case 3:
                    break;
                default:
                    break;
            }

        } while (opt != 0);
    }


}
