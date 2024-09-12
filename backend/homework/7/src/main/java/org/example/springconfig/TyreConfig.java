package org.example.springconfig;

import org.example.entities.Tyre;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages =  "org.example.tyreservice")
public class TyreConfig {
    @Bean("mrf")
    Tyre tyre1()
    {
        return new Tyre("mrf",20000);
    }
    @Bean("bridgestone")
    Tyre tyre2()
    {
        return new Tyre("bridgestone",22000);
    }
}
