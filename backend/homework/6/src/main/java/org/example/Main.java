package org.example;

import org.example.beans.Speaker;
import org.example.beans.Tyre;

import org.example.springconfig.SpringConfig;
import org.example.vehicleservice.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {


    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(SpringConfig.class);

        Speaker speakerType1=context.getBean("bose",Speaker.class);
        Speaker speakerType2=context.getBean("sony",Speaker.class);

        Tyre tyreType1=context.getBean("mrf",Tyre.class);
        Tyre tyreType2=context.getBean("bridgestone",Tyre.class);
        VehicleService.addToList("Audi",speakerType1,tyreType1);
        VehicleService.addToList("Ferrari",speakerType2,tyreType2);
        VehicleService.addToList("Mercedes",speakerType2,tyreType1);
        VehicleService.addToList("Lambo",speakerType1,tyreType2);
        VehicleService.topVehicle();
        context.close();
    }
}