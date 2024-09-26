package org.example.springconfig;

import org.example.beans.Speaker;
import org.example.beans.Tyre;
import org.example.speakerservice.SpeakerService;
import org.example.tyreservice.TyreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.vehicleservice")
public class SpringConfig {
    @Bean("sony")
    Speaker speaker1()
    {
        return SpeakerService.generateSpeaker("sony",10000);
    }
    @Bean("bose")
    Speaker speaeker2()
    {
        return SpeakerService.generateSpeaker("bose",12000);
    }
    @Bean("mrf")
    Tyre tyre1()
    {
        return TyreService.generateTyre("mrf",20000);
    }
    @Bean("bridgestone")
    Tyre tyre2()
    {
        return TyreService.generateTyre("bridgestone",22000);
    }
}
