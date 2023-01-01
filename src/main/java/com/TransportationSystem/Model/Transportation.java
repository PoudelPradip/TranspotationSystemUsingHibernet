package com.TransportationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Transportation {
    private String vehicleId;
    private String typeOfVehicle;
    private float mileageOfVehicle;
    private String gearType;
    private String custId;
    private String custName;
    private long mob;
    private String email;
    private String drivingLicense;
    private float durationForRent;
    private float[] rateOfTheVehicle;
    private float totalCalculatedRentAmt;
}
