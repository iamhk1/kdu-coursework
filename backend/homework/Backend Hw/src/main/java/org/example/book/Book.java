package org.example.book;

public class Book {
    private String title;
    private String isbn;
    private String genre;
    private boolean checkedOut;
    public Book(String title,String isbn,String genre)
    {
        this.title=title;
        this.isbn=isbn;
        this.genre=genre;
        checkedOut=false;
    }
    public String getGenre()
    {
        return this.genre;
    }
    public void setCheckedOut(boolean checkedOut)
    {
        this.checkedOut=checkedOut;
    }
    public String getTitle()
    {
        return title;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public boolean getCheckedOut()
    {
        return checkedOut;
    }
}
