package com.perennialsys.service;
import com.perennialsys.entity.Book;
import com.perennialsys.entity.HoldRequest;
import java.util.ArrayList;
import java.util.List;

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


    public void issuedBook(String title) {
        ArrayList<Book> listOfBooks = new ArrayList<>();




    }
}
