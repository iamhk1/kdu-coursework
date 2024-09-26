package org.q4;

import java.util.Comparator;

public class PubDateDescComparator implements Comparator<Book> {
    public int compare(Book book1,Book book2)
    {
        int yearDiff=Integer.compare(book1.getYear(),book2.getYear());
        if(yearDiff!=0)
            return yearDiff;
        return book1.getTitle().compareTo(book2.getTitle());
    }
}
