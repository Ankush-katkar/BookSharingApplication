package com.perennialsys.service;

import com.perennialsys.BookStore;
import com.perennialsys.entity.Book;
import com.perennialsys.entity.Borrower;
import com.perennialsys.entity.HoldRequest;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BookService {


    public BookService() {
    }



    public void issuedBook(Borrower borrower,Book b) {
        Date today = new Date();

        ArrayList<HoldRequest> hRequests = b.holdRequests;


        for (int i = 0; i < hRequests.size(); i++) {
            HoldRequest hr = hRequests.get(i);

            //Remove that hold request which has expired
            long days = ChronoUnit.DAYS.between(today.toInstant(), hr.getRequestDate().toInstant());
            days = 0 - days;

            if (days > BookStore.getInstance().getHoldRequestExpiry()) {
                removeHoldRequest(b);
                hr.getBorrower().removeHoldRequest(hr);
            }
        }

        if (b.isTaken) {
            System.out.println("\nThe book " + b.name + " is already issued.");
            System.out.println("Would you like to place the book on hold? (y/n)");

            Scanner sc = new Scanner(System.in);
            String choice = sc.next();

            if (choice.equals("y")) {
                makeHoldRequest(borrower);
            }
        } else {
            if (!b.holdRequests.isEmpty()) {
                boolean hasRequest = false;

                for (int i = 0; i < b.holdRequests.size() && !hasRequest; i++) {
                    if (b.holdRequests.get(i).getBorrower() == borrower)
                        hasRequest = true;

                }

                if (hasRequest) {

                    if (b.holdRequests.get(0).getBorrower() == borrower)
                        serviceHoldRequest(b.holdRequests.get(0),b);

                    else {
                        System.out.println("\nSorry some other users have requested for this book earlier than you. So you have to wait until their hold requests are processed.");
                        return;
                    }
                } else {
                    System.out.println("\nSome users have already placed this book on request and you haven't, so the book can't be issued to you.");

                    System.out.println("Would you like to place the book on hold? (y/n)");

                    Scanner sc = new Scanner(System.in);
                    String choice = sc.next();

                    if (choice.equals("y")) {
                        makeHoldRequest(borrower);
                    }

                    return;
                }
            }

            //If there are no hold requests for this book, then simply issue the book.
            b.setTaken(true);

            System.out.println("\nThe book " + b.name + " is successfully issued to " + borrower.getName() + ".");

        }
    }

    public void serviceHoldRequest(HoldRequest hr, Book b) {
        removeHoldRequest(b);
        hr.getBorrower().removeHoldRequest(hr);
    }

    public void addHoldRequest(HoldRequest hr, Book b) {
        b.holdRequests.add(hr);
    }

    public void removeHoldRequest(Book b) {
        if (!b.holdRequests.isEmpty()) {
            b.holdRequests.remove(0);
        }
    }

    public void makeHoldRequest(Borrower borrower) {
        boolean makeRequest = true;

    }

    public void placeBookOnHold(Borrower bor, Book book) {
        HoldRequest hr = new HoldRequest(bor, book, new Date());
        addHoldRequest(hr,book);
        bor.addHoldRequest(hr);
        System.out.println("\nThe book " + book.name + " has been successfully placed on hold by borrower " + bor.getName() + ".\n");
    }


}

