package org.example.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
@Configuration
@ComponentScan("org.example.factories")
@Import({InventoryConfig.class,SpeakerConfig.class,TyreConfig.class})
public class MainConfig {
}
