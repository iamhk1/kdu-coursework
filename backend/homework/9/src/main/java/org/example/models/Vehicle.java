package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *Vehicle class to store all member variables of Vehicle
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private String vehicleName;
    private double vehiclePrice;
    private Tyre tyre;
    private Speaker speaker;

}
