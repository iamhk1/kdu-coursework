package com.kdu.caching;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching

public class Main {
    /**
     *Spring application Starting point
     */
    public static void main(String []args)
    {
        SpringApplication.run(Main.class, args);
    }
}
