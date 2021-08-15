package org.dto;

import javax.persistence.*;

/*
* When using @GeneratedValue(strategy=GenerationType.AUTO) in both UserDetails and here we got sequenced Id number.
* Like UserDetails got 1 and Vehicle got 2. How to fix that?
* We changed strategy of GeneratedValue by creating private SequenceGenerator.
* The @GeneratedValue(strategy=GenerationType.AUTO) is global.
* */
@Entity
@SequenceGenerator(name="PRIVATE_SEQ", sequenceName="private_sequence")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ")
    private int vehicleId;
    private String vehicleName;

    //@OneToOne
    //private UserDetails userDetails;//creates a bidirectional mapping...Both UseDetails and Vehicle has each others key

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    /*public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }*/
}
