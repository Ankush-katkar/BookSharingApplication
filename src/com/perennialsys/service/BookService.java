package com.perennialsys.service;
import com.perennialsys.entity.Book;
import com.perennialsys.entity.Borrower;
import com.perennialsys.entity.HoldRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {
    private List<HoldRequest> holdRequests;

    public List<HoldRequest> getHoldRequests() {
        return holdRequests;
    }

    public void setHoldRequests(List<HoldRequest> holdRequests) {
        this.holdRequests = holdRequests;

    }

    public BookService(List<HoldRequest> holdRequests) {
        this.holdRequests = holdRequests;
    }

    @Override
    public String toString() {
        return "BookService{" +
                "holdRequests=" + holdRequests +
                '}';
    }

    public BookService() {
    }

    public void addHoldRequest(HoldRequest hr)
    {
        holdRequests.add(hr);
    }

    public void removeHoldRequest()
    {
        if(!holdRequests.isEmpty())
        {
            holdRequests.remove(0);
        }
    }


    public void issuedBook(Borrower borrower) {
        List<HoldRequest> hRequests = holdRequests;
        Book b = new Book();
        if (isTaken)
        {
            System.out.println("\nThe book " + name + " is already issued.");
            System.out.println("Would you like to place the book on hold? (y/n)");

            Scanner sc = new Scanner(System.in);
            String choice = sc.next();

            if (choice.equals("y"))
            {
                makeHoldRequest(borrower);
            }
        }

        else
        {
            if (!holdRequests.isEmpty())
            {
                boolean hasRequest = false;

                for (int i = 0; i < holdRequests.size() && !hasRequest;i++)
                {
                    if (holdRequests.get(i).getBorrower() == borrower)
                        hasRequest = true;

                }

                if (hasRequest)
                {

                    if (holdRequests.get(0).getBorrower() == borrower)
                        serviceHoldRequest(holdRequests.get(0));

                    else
                    {
                        System.out.println("\nSorry some other users have requested for this book earlier than you. So you have to wait until their hold requests are processed.");
                        return;
                    }
                }
                else
                {
                    System.out.println("\nSome users have already placed this book on request and you haven't, so the book can't be issued to you.");

                    System.out.println("Would you like to place the book on hold? (y/n)");

                    Scanner sc = new Scanner(System.in);
                    String choice = sc.next();

                    if (choice.equals("y"))
                    {
                        makeHoldRequest(borrower);
                    }

                    return;
                }
            }

            //If there are no hold requests for this book, then simply issue the book.
            setIssuedStatus(true);


        }
}
