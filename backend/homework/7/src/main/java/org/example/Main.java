package org.example;
import org.example.getdetails.PrintDetails;
import org.example.entities.Vehicle;
import org.example.factories.Factory1;
import org.example.factories.Factory2;
import org.example.springconfig.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        var context=new AnnotationConfigApplicationContext(MainConfig.class);
        Factory1 factory1=context.getBean(Factory1.class);
        Factory2 factory2=context.getBean(Factory2.class);
        List<Vehicle> vehicleFromFacrory1=factory1.getInventoryStore().getAllVehicle();
        List<Vehicle> vehicleFromFactory2=factory2.getInventoryStore().getAllVehicle();
        vehicleFromFacrory1.addAll(vehicleFromFactory2);
        PrintDetails.printMin(vehicleFromFacrory1);
        PrintDetails.printMax(vehicleFromFacrory1);
    }
}
