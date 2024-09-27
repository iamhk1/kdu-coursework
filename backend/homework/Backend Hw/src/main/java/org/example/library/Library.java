package org.example.library;

import org.example.author.Author;
import org.example.book.Book;
import org.example.patron.Patron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> books=new ArrayList<>();
    private List<Author>authors=new ArrayList<>();
    private List<Patron>patrons=new ArrayList<>();
    private List<Book>checkedOutBooks=new ArrayList<>();
    private Map<Book,Integer>checkOutCount=new HashMap<>();
    public Map<Book,Integer>getCheckOutCount()
    {
        return checkOutCount;
    }
    public void setCheckOutCount(Book book)
    {
        int val=getCheckOutCount().get(book);
        ++val;
        getCheckOutCount().put(book,val);
    }
    public void addBooks(Book book)
    {
        books.add(book);
    }
    public void addAuthor(Author author)
    {
        authors.add(author);
    }
    public void addPatron(Patron patron)
    {
        patrons.add(patron);

    }
    public void addCheckedOutBooks(Book book)
    {
        checkedOutBooks.add(book);

    }
    public List<Book> getBooks()
    {
        return books;
    }
    public List<Author> getAuthors()
    {
        return authors;
    }
    public List<Patron> getPatrons()
    {
        return patrons;
    }
    public List<Book> getCheckedOutBooks()
    {
        return checkedOutBooks;
    }
    public void checkoutBook(Book book,Patron patron)
    {
        int isAvailable=-1;
        for(int i=0;i<books.size();i++)
        {
            if(books.get(i).getTitle().equals(book))
            {
                if(!books.get(i).getCheckedOut())
                {
                    isAvailable=i;
                    break;
                }
            }
        }
        if(isAvailable==-1){
            System.out.println("Not available at the moment");
            return ;
        }
        if(patron.canCheckout())
        {
            patron.addCheckedOutBook(book);
            int checkoutlimit=patron.getCheckoutLimit();
            --checkoutlimit;
            patron.setCheckoutLimit(checkoutlimit);
            books.get(isAvailable).setCheckedOut(true);
        }

    }
    public void returnBook(Book book,Patron patron)
    {
        int found=-1;
        for(int i=0;i<books.size();i++)
        {
            if(books.get(i).getTitle().equals(book)&&books.get(i).getCheckedOut())
            {
                found=1;
                break;
            }
        }
        if(found==-1){
            System.out.println("Book not found");
            return ;
        }
        patron.removeCheckedOutBook(book);
        patron.setCheckoutLimit(patron.getCheckoutLimit()+1);
        book.setCheckedOut(false);
        books.add(book);

    }
}
