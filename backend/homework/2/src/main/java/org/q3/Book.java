package org.q3;
import org.q2.SentimentAnalyzer;

import java.util.logging.Logger;
public class Book {
    static Logger logger= Logger.getLogger(String.valueOf(Book.class));
    private String title;
    private String author;
    private int publicationYear;
    private double averageRating;
    private int ratingsCount;
    private String imageUrl;
    public String getTitle() {
        return title;
    }
    public void setRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
    public String getAuthor() {
        return author;
    }

    public double getAverageRating() {
        return averageRating;
    }
    public int getPublicationYear() {
        return publicationYear;
    }


    public int getRatingsCount() {
        return ratingsCount;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public  void fnPrintDetails()
    {

        logger.info("Author: "+getAuthor());
        logger.info("Average Rating: "+getAverageRating());
        logger.info("Img URL: "+getImageUrl());
        logger.info("Title: "+getTitle());
        logger.info("Publication Year: "+getPublicationYear());
        logger.info("Ratings Count: "+getRatingsCount());
    }
}
