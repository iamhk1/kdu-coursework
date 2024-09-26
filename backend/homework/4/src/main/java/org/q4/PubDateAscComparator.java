package org.q4;
import java.util.Comparator;

public class PubDateAscComparator implements Comparator<Book>{
    public int compare(Book book1,Book book2)
    {
        int yearDiff=Integer.compare(book2.getYear(),book1.getYear());
        if(yearDiff!=0)
            return yearDiff;
        return book1.getTitle().compareTo(book2.getTitle());
    }
}
