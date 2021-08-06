package com.perennialsys;

import com.perennialsys.entity.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {

    private static BookStore obj;
    ArrayList<Book> listOfBooks = new ArrayList<>();

    public static BookStore getInstance() {
        if (obj == null) {
            obj = new BookStore();
        }

        return obj;
    }


    public ArrayList<Book> searchForBooks() throws IOException {
        String choice;
        String name = "", author = "";
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\nEnter either '1' or '2'  for search by Name or Author of Book respectively: ");
            choice = sc.next();

            if (choice.equals("1") || choice.equals("2"))
                break;
            else
                System.out.println("\nWrong Input!");
        }

        if (choice.equals("1")) {
            System.out.println("\nEnter the Name of the Book: ");
            name = reader.readLine();
        }
        if (choice.equals("2")) {
            System.out.println("\nEnter the Author of the Book: ");
            author = reader.readLine();
        }
        ArrayList<Book> matchedBooks = new ArrayList();
        //Retrieving all the books which matched the user's search query
        for (int i = 0; i < listOfBooks.size(); i++) {
            Book b = listOfBooks.get(i);

            if (choice.equals("1")) {
                if (b.getName().equals(name))
                    matchedBooks.add(b);
            } if (choice.equals("2")) {
                if (b.getAuthors().equals(author))
                    matchedBooks.add(b);
            }

        }

        //Printing all the matched Books
        if (!matchedBooks.isEmpty()) {
            System.out.println("\nThese books are found: \n");

            System.out.println("------------------------------------------------------------------------------");
            System.out.println("No.\t\t\tName\t\t\tAuthors\t\t\tISBN");
            System.out.println("------------------------------------------------------------------------------");

            for (int i = 0; i < matchedBooks.size(); i++) {
                System.out.print(i + "-" + "\t\t");
                matchedBooks.get(i).toString();
                System.out.print("\n");
            }
            System.out.println(matchedBooks);

            return matchedBooks;
        } else {
            System.out.println("\nSorry. No Books were found related to your query.");
            return null;
        }
    }

}
