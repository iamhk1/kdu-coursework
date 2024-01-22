package org.example.speakerservice;


import org.example.beans.Speaker;

public class SpeakerService {
    private SpeakerService()
    {

    }
    public static Speaker generateSpeaker(String name,double price)
    {
        return new Speaker(name,price);
    }

}
