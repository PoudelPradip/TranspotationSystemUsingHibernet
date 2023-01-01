package com.TransportationSystem.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="vehicle_id")
    private String vehicleId;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "vehicle_mileage")
    private float mileageOfVehicle;

    @Column(name="gear_type")
    private String gearType;

    @Column(name="custId")
    private String custId;

    public Vehicle(String vehicleId, String vehicleType, float mileageOfVehicle, String gearType, String custId) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.mileageOfVehicle = mileageOfVehicle;
        this.gearType = gearType;
        this.custId = custId;
    }
}