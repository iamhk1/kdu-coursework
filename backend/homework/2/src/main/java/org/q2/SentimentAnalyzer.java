package org.q2;
import org.q1.StudentUtil;

import java.util.*;
import java.util.logging.Logger;
public class SentimentAnalyzer {
    static Logger logger= Logger.getLogger(String.valueOf(SentimentAnalyzer.class));
    public static int[] detectProsAndCons(String review,String[][]featureSet,String[]posOpinionWords,String[]negOpinionWords)
    {
            int []featureOpinions=new int [featureSet.length];
            for (int i=0;i<featureSet.length;i++)
            {
                int rating=0;
                for(int j=0;j<featureSet[i].length;j++) {
                    String feature=featureSet[i][j];
                    int curRating = getOpinionOnFeature(review,feature,posOpinionWords,negOpinionWords);
                    if(curRating!=0)
                    {

                        rating=curRating;
                        break;
                    }
                }

                featureOpinions[i]=rating;
            }
            return featureOpinions;
    }
    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
            int rating=checkForWasPhrasePattern(review,feature,posOpinionWords,negOpinionWords);
            if(rating!=0)
                return rating;
            rating=checkForOpinionFirstPattern(review,feature,posOpinionWords,negOpinionWords);
            return rating;
    }
    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords)
    {
        int opinion=0;
        feature=feature+" was ";
        for(int i=0;i<posOpinionWords.length;i++)
        {
            if(review.contains(feature.concat(posOpinionWords[i]))){
                opinion=1;
                return opinion;
            }

        }
        for(int i=0;i< negOpinionWords.length;i++)
        {
            if(review.contains(feature.concat(negOpinionWords[i])))
            {
                opinion=-1;

                return opinion;
            }
        }
        return opinion;
    }
    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        for(int i=0;i<posOpinionWords.length;i++)
        {
            if(review.contains(posOpinionWords[i]+" "+feature)){
                opinion = 1;
                return opinion;
            }
        }
        for(int i=0;i<negOpinionWords.length;i++)
        {
            if(review.contains(negOpinionWords[i]+" "+feature)) {
                opinion=-1;

                return opinion;

            }
        }
        return opinion;
    }



    public static void main(String[] args) {
        String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" }
            };
        String[] posOpinionWords = { "good", "fantastic", "friendly",
                "great", "excellent", "amazing", "awesome",
                "delicious" };

        String[] negOpinionWords = { "slow", "bad", "horrible",
                "awful", "unprofessional", "poor" };

        int[] featureOpinions = detectProsAndCons(review.toLowerCase(), featureSet,
                posOpinionWords, negOpinionWords);
        logger.info("Options on Features:"+Arrays.toString(featureOpinions));
    }
}

