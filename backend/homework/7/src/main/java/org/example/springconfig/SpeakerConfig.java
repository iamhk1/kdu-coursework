package org.example.springconfig;

import org.example.entities.Speaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages =  "org.example.speakerservice")

public class SpeakerConfig {
    @Bean("sony")
    Speaker speaker1()
    {

        return new Speaker("sony",10000);
    }
    @Bean("bose")
    Speaker speaker2()
    {

        return new Speaker("bose",12000);
    }
}
