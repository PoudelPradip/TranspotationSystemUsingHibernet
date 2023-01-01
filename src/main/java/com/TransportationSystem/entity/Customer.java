package com.TransportationSystem.entity;

//'cust_id', 'cust_name', 'mobile_no', 'email', 'driving_lisence',
// 'duration_Of_rent', 'rate_of_vehicle'

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "cust_id")
    private String custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "mobile_no")
    private long mobileNo;

    @Column(name = "email")
    private String email;

    @Column(name = "duration_of_rent")
    private float durationOfRent;

    @Column(name = "final_rent")
    private float finalRentOfVehicle;
}
