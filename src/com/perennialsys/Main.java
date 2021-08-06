package com.perennialsys;

import com.perennialsys.entity.Book;
import com.perennialsys.entity.Borrower;
import com.perennialsys.service.BookService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {
    static void menu() {
        System.out.println("1-Add new  book ");
        System.out.println("2-Display all book");
        System.out.println("3-Search  book");
        System.out.println("4-Add new user");
        System.out.println("5-Issue Book ");
        System.out.println("0-Exit");
    }

    public static void main(String[] args) throws IOException {
        int opt;
        BookStore b = new BookStore();

        BookService bookService = new BookService();
        Borrower borrower = new Borrower();
        Scanner scanner = new Scanner(System.in);

        do {
            Book book = new Book();

            menu();
            opt = scanner.nextInt();
            switch (opt) {


                case 1:
                    scanner.nextLine();
                    System.out.println("Enter the book name");
                    book.setName(scanner.nextLine());
                    scanner.nextLine();
                    Set<String> set = new HashSet<>();
                    System.out.println("Enter the author name ");
                    set.add(scanner.nextLine());
                    //book.setDate(new Date());

                    book.setHoldRequests(new ArrayList<>());
                    book.setAuthors(set);
                    int hashcode = book.hashCode();
                    book.setIsbn(hashcode);
                    book.addNewBook(book);
                    b.listOfBooks.add(book);


/*
                    System.out.println("Enter the user id");
                    borrower.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter the user name");
                    borrower.setName(scanner.nextLine());
                    borrower.setOnHoldBooks(new ArrayList<>());
                    bookService.placeBookOnHold(borrower,book);
*/
                    break;


                case 2:
                    for (Book book1 : b.listOfBooks) {
                        System.out.println("__________________________________________________________");
                        System.out.println("BookId\t\tBookName\t\tBookAuthor\t\tDate added\t\t\t\t");
                        System.out.println(book1);
                        System.out.println("__________________________________________________________");


                    }
                    break;
                case 3:
                    b.searchForBooks();
                    break;
                case 4:
                    System.out.println("Enter the user id");
                    borrower.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter the user name");
                    borrower.setName(scanner.nextLine());
                    bookService.placeBookOnHold(borrower, book);
                    break;
                case 5:
                    System.out.println("Enter the book number");
                    book.setIsbn(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter the book name");
                    book.setName(scanner.nextLine());
                    scanner.nextLine();

                    //book.setDate(new Date());

                    book.setHoldRequests(new ArrayList<>());
                    book.addNewBook(book);
                    b.listOfBooks.add(book);
                    System.out.println("Enter the user id");
                    borrower.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter the user name");
                    borrower.setName(scanner.nextLine());
                    borrower.setOnHoldBooks(new ArrayList<>());

                    bookService.issuedBook(borrower, book);
                    break;
                default:
                    break;
            }

        } while (opt != 0);
    }


}
