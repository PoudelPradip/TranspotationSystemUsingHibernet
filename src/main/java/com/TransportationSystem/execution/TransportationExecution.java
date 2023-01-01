package com.TransportationSystem.execution;

import com.TransportationSystem.Model.TransportSystem;
import com.TransportationSystem.Model.Transportation;
import com.TransportationSystem.Service.TransportationService;
import com.TransportationSystem.database.TransportationDBOperation;
import org.hibernate.SessionFactory;

import java.util.Scanner;

/*
* Transportation System : Write java program using encapsulation on transport system. Consider Govt. Transport department will provide rent of different type of vehicle (Bus, Truck, Taxi, Scooty, bike) to the registered customer.
                        Customer should provide valid mobile, email, driving license while booking the vehicle. Transport will charge based on the rate of the of the vehicle and the for the time (in hour) customer need
						the vehicle.
 [
	Hint: create a class name 'TransportSystem' with instance variables as vehicleId, typeOfVehicle, milageOfVehicle, gearType, custId, custName, mob, email, drivingLicense, durationForRent (in hour).
	      take input as typeOfVechicle (Bus, Truck, Taxi etc), vehicleId, milageOfVehicle, custId, custName, mob, email, drivingLisence, durationOfRent (in hr)
			While taking input need to put few validation. Find below the validation rules:
				1. vehicleId should be in the format of 'B01'(when vehicle type: Bus)/'T01'(when vehicle type: Truck)/'TX01'(when vehicle type: Taxi)/'SC01'(when vehicle type: Scooty)/ 'BK01'(when vehicle type: Bike)
			If all above condition satisfies then proceed to book the vehicle.
			at the time of booking rate of vehicle calculation logic will be = rateOfTheVehicle * durationForRent);
			consider rate of below vehicle rate are static and final,
			rateOfTheVehicle = [$100/hr, $150/hr, $60/hr, $30/hr, $40/hr]
			Where for Bus rate : rateOfTheVehicle[0] : $100/hr
			Where for Truck rate:  rateOfTheVehicle[1]: $150/hr
			Where for Taxi rate: rateOfTheVehicle[2] : $60/hr
			Where for Scooty rate: rateOfTheVehicle[3] : $30/hr
			Where for Bike rate: rateOfTheVehicle[4] : $40/hr
 ]
 Use Hibernate xml configuration to store data in database. We need to store Data in 2 table named 'vehicle' and 'customer', under new schema names 'transporation'.
 We need to store data in
				1. 'vehicle' table with column  as 'vehicle_id', 'vehicle_type', 'vehicle_milage', 'gear_type' and cust_id
				2. 'customer' table with column as 'cust_id', 'cust_name', 'mobile_no', 'email', 'driving_lisence', 'duration_Of_rent', 'rate_of_vehicle'.
*
* */
public class TransportationExecution {

    public static void exitProgram(int counter) {
        if (counter == TransportSystem.numberOfTrialAndErr) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Transportation transportation = new Transportation();
        TransportationService transportationService = new TransportationService();
        Scanner scanner = new Scanner(System.in);

        //take input as drivingLisence, durationOfRent (in hr)\
        int counter = 0;
        while(counter < TransportSystem.numberOfTrialAndErr) {
            System.out.println("Enter Type of Vehicle (For ex. Bus, Truck, Taxi, Scooty, Bike etc.) ::");
            String typeOfVehicle = scanner.next();
            if (transportationService.validateTypeOfVehicle(typeOfVehicle)) {
                transportation.setTypeOfVehicle(typeOfVehicle);
                break;
            } else {
                counter++;
            }
        }

        exitProgram(counter);

        counter = 0;
        while(counter < TransportSystem.numberOfTrialAndErr) {
            System.out.println("Enter Vehicle Id (For Ex. Bus (B01), Truck (T01), Taxi (TX01), Scooty(SC01), Bike(BK01)) ::");
            String vehicleId = scanner.next();
            if (transportationService.validateVehicleId(vehicleId)) {
                transportation.setVehicleId(vehicleId);
                break;
            } else {
                counter++;
            }
        }

        exitProgram(counter);

        System.out.println("Enter Mileage of Vehicle :: ");
        float mileageOfVehicle = scanner.nextFloat();
        transportation.setMileageOfVehicle(mileageOfVehicle);

        System.out.println("Enter Gear Type::");
        String gearType = scanner.next();
        transportation.setGearType(gearType);

        System.out.println("Enter Customer Id::");
        String custId = scanner.next();
        transportation.setCustId(custId);

        System.out.println("Enter Customer Name::");
        String custName = scanner.next();
        transportation.setCustName(custName);

        System.out.println("Enter Mobile Number ::");
        long mobileNumber = scanner.nextLong();
        transportation.setMob(mobileNumber);

        System.out.println("Enter The email Address ::");
        String emailAddress = scanner.next();
        transportation.setEmail(emailAddress);

        System.out.println("Enter Driving license ::");
        String drivingLicense  = scanner.next();
        transportation.setDrivingLicense(drivingLicense);

        System.out.println("Enter Duration Of Vehicle ::");
        float durationForRent = scanner.nextFloat();
        transportation.setDurationForRent(durationForRent);

        //get Total Rent for Vehicles
        transportationService.calculateFinalRentOfVehicle(transportation);

        TransportationDBOperation transportationDBOperation = new TransportationDBOperation();
        //create session Factory
        SessionFactory sessionFactory = transportationDBOperation.createSessionFactory();

        //store data to DB
        transportationDBOperation.storeData(transportation, sessionFactory);

        //display the stored data
        transportationDBOperation.displayStoredData(sessionFactory);
    }
}