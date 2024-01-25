package org.example.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class VehicleDTO {
    @NonNull
    private String vehicleName;
    @NonNull
    private Double vehiclePrice;
    @NonNull
    private String tyreName;
    @NonNull
    private Double tyrePrice;
    @NonNull
    private String speakerName;
    @NotNull
    private double speakerPrice;

}
