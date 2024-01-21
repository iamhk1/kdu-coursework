package org.example.main;
import org.example.author.Author;
import org.example.book.Book;
import org.example.library.Library;
import org.example.logger.Log;
import org.example.patron.Patron;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static Library library;
    public static void main(String []args)
    {
        library=new Library();


        Author tolkien = new Author("J.R.R. Tolkien");
        Author rowling = new Author("J.K. Rowling");


        Book lotr = new Book("The Lord of the Rings", "123456789","Suspense");
        Book hp = new Book("Harry Potter", "987654321","Thriller");


        tolkien.getBooks().add(lotr);
        rowling.getBooks().add(hp);


        library.addAuthor(tolkien);
        library.addAuthor(rowling);
        library.addBooks(lotr);
        library.addBooks(hp);
        Patron alice = new Patron("Alice", 2);
        Patron bob = new Patron("Bob", 1);
        library.addPatron(alice);
        library.addPatron(bob);
        Log.info("Available Books");
        allAvailableBooks().forEach(e->Log.info(e.getTitle()));

        checkoutBook(lotr, alice);
        Log.info("TOP N BOOKS");
        topNBooks(1).forEach(e->Log.info(e.getTitle()));
        checkoutBook(hp, bob);
        Log.info("Books By J.K. Rowling are");
        findBooksByAuthor("J.K. Rowling").forEach(e->Log.info(e.getTitle()));
        Map<String,List<Book>>map=groupBooksByGenre();
        Log.info("Books grouped based on Genre");
        for(String s:map.keySet()){
            Log.info("Genre:"+s);
            map.get(s).forEach(e->Log.info(e.getTitle()));
        }


    }
    public static List<Book>allAvailableBooks()
    {
        List<Book>allBooks=library.getBooks();
        List<Book>availableBooks=allBooks.stream().filter(e->!e.getCheckedOut()).collect(Collectors.toList());
        return availableBooks;
    }
    public static void checkoutBook(Book book,Patron patron)
    {
        int isAvailable=-1;
        for(int i=0;i<library.getBooks().size();i++)
        {
            if(library.getBooks().get(i).getTitle().equals(book.getTitle()))
            {

                if(!library.getBooks().get(i).getCheckedOut())
                {
                    isAvailable=i;
                    break;
                }
            }
        }
        if(isAvailable==-1){
            Log.error("Not available at the moment");
            return ;
        }
        if(patron.canCheckout())
        {
            patron.addCheckedOutBook(book);
            int checkoutlimit=patron.getCheckoutLimit();
            --checkoutlimit;
            patron.setCheckoutLimit(checkoutlimit);
            library.getBooks().get(isAvailable).setCheckedOut(true);
            library.getCheckOutCount().put(book,library.getCheckOutCount().getOrDefault(book,0)+1);
        }
    }
    public static List<Book> topNBooks(int topN)
    {
        if(topN>library.getCheckOutCount().size()) {
            Log.error("N is greater than the number of boks");
            return new ArrayList<>();
        }
        return library.getCheckOutCount().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(topN)
                .map(Map.Entry::getKey) // Extracting the Book from each entry
                .collect(Collectors.toList());
    }
    public static  List<Book> findBooksByAuthor(String name)
    {
        List<Author>authors=library.getAuthors();
        return authors.stream()
                .filter(author -> name.equals(author.getName()))
                .findFirst()
                .map(Author::getBooks)
                .orElse(null);
    }

    public static Map<String,List<Book>>groupBooksByGenre()
    {
        List<Book>books=library.getBooks();
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
    }


}
