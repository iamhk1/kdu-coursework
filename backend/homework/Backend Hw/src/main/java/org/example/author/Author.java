package org.example.author;

import org.example.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Author {
   private String name;
   private List<Book> books;
   public Author(String name)
   {
       this.name=name;
       books=new ArrayList<>();

   }
   public  void addBook(List<Book>book)
   {
       this.books=book;
   }
   public String getName()
   {
       return name;

   }
   public List<Book> getBooks()
   {
       return this.books;
   }

}
