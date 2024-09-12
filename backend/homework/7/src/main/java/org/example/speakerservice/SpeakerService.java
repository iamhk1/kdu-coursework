package org.example.speakerservice;
import org.example.entities.Speaker;
import org.example.springconfig.SpeakerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpeakerService {
    public  Speaker getSpeaker(String speakerName)
    {
        var context=new AnnotationConfigApplicationContext(SpeakerConfig.class);
        return context.getBean(speakerName,Speaker.class);

    }
}
