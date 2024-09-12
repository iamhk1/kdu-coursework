package org.example.factories;

import org.example.entities.Speaker;
import org.example.entities.Tyre;
import org.example.entities.Vehicle;
import org.example.inventory.InventoryStore;
import org.example.speakerservice.SpeakerService;
import org.example.springconfig.SpeakerConfig;
import org.example.springconfig.TyreConfig;
import org.example.tyreservice.TyreService;
import org.example.vehicleservice.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Factory2 implements VehicleService {
    TyreService tyreService;
    SpeakerService speakerService;
    private String location;
    private double price;
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double calculatePrice(double price)
    {
        return (price+0.15*price);
    }

    public InventoryStore getInventoryStore() {
        return inventoryStore;
    }

    public void setInventoryStore(InventoryStore inventoryStore) {
        this.inventoryStore = inventoryStore;
    }

    InventoryStore inventoryStore;
    @Autowired
    public Factory2(InventoryStore inventoryStore, TyreService tyreService, SpeakerService speakerService)
    {
        this.inventoryStore=inventoryStore;
        this.tyreService=tyreService;
        this.speakerService=speakerService;
    }
    @PostConstruct
    @Override
    public void createVehicles()
    {
        List<Vehicle>vehicleService=new ArrayList<>();
        AnnotationConfigApplicationContext contextSpeaker=new AnnotationConfigApplicationContext(SpeakerConfig.class);
        SpeakerService speakerService1=contextSpeaker.getBean(SpeakerService.class);
        Speaker speaker1 = speakerService1.getSpeaker("bose");
        Speaker speaker2 =speakerService1.getSpeaker("sony");
        AnnotationConfigApplicationContext contextTyre=new AnnotationConfigApplicationContext(TyreConfig.class);
        TyreService tyreService1=contextTyre.getBean(TyreService.class);
        Tyre tyre1 = tyreService1.getTyre("bridgestone");
        Tyre tyre2 =tyreService1.getTyre("mrf");
        vehicleService.add(GenerateVehicle.generateNewVehicle("Lambo",speaker1,tyre1,calculatePrice(250000)));
        vehicleService.add(GenerateVehicle.generateNewVehicle("Honda",speaker2,tyre2,calculatePrice(140000)));
        vehicleService.add(GenerateVehicle.generateNewVehicle("Mercedes",speaker2,tyre1,calculatePrice(3500000)));
        inventoryStore.setAllVehicle(vehicleService);
    }

}
