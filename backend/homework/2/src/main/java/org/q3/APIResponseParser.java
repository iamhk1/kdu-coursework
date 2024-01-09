package org.q3;
import org.q2.SentimentAnalyzer;

import java.util.logging.Logger;
public class APIResponseParser {
    static Logger logger= Logger.getLogger(String.valueOf(APIResponseParser.class));
    public static void main(String args[]){
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>";
          Book book=new Book();
          book=parse(response);
        book.fnPrintDetails();
    }
    public static  Book parse(String response)
    {
        Book book=new Book();
        book.setAuthor(parse(response,"author"));
        book.setAverageRating(Double.parseDouble(parse(response,"average_rating")));
        book.setImageUrl(parse(response,"image_url"));
        book.setTitle(parse(response,"title"));
        book.setPublicationYear(Integer.parseInt(parse(response,"original_publication_year")));
        book.setRatingsCount(Integer.parseInt(parse(response,"ratings_count").replaceAll(",","")));
        String parentChild[]={"author","name"};
        String name=parse(response,parentChild);
        logger.info(name);
        return book;
    }
    public  static String parse(String response,String attribute)
    {
        int startIndex=response.indexOf(attribute);
        String endAttribute="</"+attribute+">";
        int endIndex=response.indexOf(endAttribute,startIndex);
        if(startIndex==-1)
        {
            //log
            return " ";
        }
        while(startIndex<response.length()&&response.charAt(startIndex)!='>')
            ++startIndex;
        ++startIndex;
        StringBuilder data=new StringBuilder();
        while(startIndex<endIndex)
        {
            data.append(response.charAt(startIndex));
            ++startIndex;
        }
        return data.toString();
    }
    public static String parse(String response,String ParentChild[])
    {

        String parent=ParentChild[0];
        String parentEndAttribute="</"+parent+">";
        String child=ParentChild[1];
        int startIndexParent=response.indexOf(parent);
        int endIndexParent=response.indexOf(parentEndAttribute,startIndexParent);
        String parentString=response.substring(startIndexParent,endIndexParent);
        int startIndexChild=parentString.indexOf(child);
        if(startIndexChild==-1){
            return "";
        }
        while(startIndexChild<parentString.length()&&parentString.charAt(startIndexChild)!='>') {
            ++startIndexChild;
        }
        ++startIndexChild;
        StringBuilder childString=new StringBuilder();
        while(startIndexChild<parentString.length()&&parentString.charAt(startIndexChild)!='<') {
            childString.append(parentString.charAt(startIndexChild));
            ++startIndexChild;
        }
        return childString.toString();
    }
}

