package com.TransportationSystem.Service;

import com.TransportationSystem.Model.TransportSystem;
import com.TransportationSystem.Model.Transportation;

public class TransportationService {

    public boolean validateTypeOfVehicle(String typeOfVehicle) {
        switch (typeOfVehicle.toUpperCase()) {
            case "BUS":
            case "TRUCK":
            case "SCOOTY":
            case "TAXI":
            case "BIKE":
                return true;
        }
        return false;
    }

    public boolean validateVehicleId(String vehicleId) {

        for(int i = 0; i < TransportSystem.vehicleIdMap.length; i++) {
            if (vehicleId.equalsIgnoreCase(TransportSystem.vehicleIdMap[i])) {
                return true;
            }
        }
        return false;
    }

    public void calculateFinalRentOfVehicle(Transportation transportation) {
        int getPosOfTheElem = 0;
        for (int i = 0; i < TransportSystem.typeOfVehicle.length; i++) {
            if (transportation.getTypeOfVehicle().equalsIgnoreCase(TransportSystem.typeOfVehicle[i])) {
                getPosOfTheElem = i;
                break;
            }
        }
        float rateOfVehicle = TransportSystem.rateOfVehicle[getPosOfTheElem];
        float totalRent = transportation.getDurationForRent() * rateOfVehicle;
        transportation.setTotalCalculatedRentAmt(totalRent);
    }
}
