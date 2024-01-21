package org.example.patron;

import org.example.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private int checkoutLimit;
    private List<Book> checkOutBooks;

    public Patron(String name, int checkoutLimit)
    {
        this.name=name;
        this.checkoutLimit=checkoutLimit;
        checkOutBooks=new ArrayList<>();
    }
    public void addCheckOutBooks(Book book)
    {
        checkOutBooks.add(book);
    }
    public boolean canCheckout() {
        return checkOutBooks.size() < checkoutLimit;
    }

    public void addCheckedOutBook(Book book) {
        checkOutBooks.add(book);
    }

    public void removeCheckedOutBook(Book book) {
        checkOutBooks.remove(book);
    }
    public String getName()
    {
        return this.name;

    }
    public int getCheckoutLimit()
    {
        return this.checkoutLimit;
    }
    public void setCheckoutLimit(int limit)
    {
        checkoutLimit=limit;
    }
    public List<Book> getCheckOutBooks()
    {
        return this.checkOutBooks;
    }
}
