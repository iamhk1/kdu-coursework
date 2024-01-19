package org.example.matchfixtures;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVWriter;

public class MatchFixtures {
    public static void assignTeams() {
        List<String> fixture = new ArrayList<>();
        fixture.add("CSK");
        fixture.add("MI");
        fixture.add("RR");
        fixture.add("RCB");

    }
    public <CSVWriter> void generateFixtures() {
//        try {
//            CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/output.csv"));
//        }
//        catch(Exception e)
//        {
//
//        }
//        //Writing data to a csv file
//        String line1[] = {"id", "name", "salary", "start_date", "dept"};
//        String line2[] = {"1", "Krishna", "2548", "2012-01-01", "IT"};
//        String line3[] = {"2", "Vishnu", "4522", "2013-02-26", "Operations"};
//        String line4[] = {"3", "Raja", "3021", "2016-10-10", "HR"};
//        String line5[] = {"4", "Raghav", "6988", "2012-01-01", "IT"};
//        //Writing data to the csv file
//        writer.writeNext(line1);
//        writer.writeNext(line2);
//        writer.writeNext(line3);
//        writer.writeNext(line4);
//        //Flushing data from writer to file
//        writer.flush();
//        System.out.println("Data entered");
//
//
//    }
    }
}
