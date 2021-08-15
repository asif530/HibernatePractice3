package org.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
//Know about GenericGenerator,GenericGenerators

import javax.persistence.*;
import java.util.*;


/*Use the object address twice...A straight forward but large method*/
/*We can also assign a name property in Entity...If we do that hibernate will make table with that name*/
@Entity
@Table(name="Aliens")
public class UserDetails {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;
    private String userName;

    /*Now a one to one mapping with vehicle
    * This makes foreign key in userTable... That means Vehicle became parent table.
    * So what if we want the other way around? We want userDetails as parent and vehicle as child
    * We will make songs a child...And UserDetails a parent
    * STEP-1: Add the entity userDetails in Songs
    * STEP-2: Add the entity Songs here
    * STEP-3: In step-1 below @oneToOne create @JoinColumns  add this: (name = "USERID", referencedColumnName = "userId")...This becomes a foreign key in child table
    * STEP-4: In step-2, Beside @oneToOne put (mappedBy = the table who will become the parent table)
    * STEP-5: Do the setEntityName(Entity object) in main file
    * */
    @OneToOne
    private Vehicle vehicle;

    @OneToOne(mappedBy = "userDetails")
    private Songs songs;

    /* If we want we can use @Id @GeneratedValue(strategy=GenerationType.AUTO) here above get Method... All the annotations are*/
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Songs getSongs() {
        return songs;
    }

    public void setSongs(Songs songs) {
        this.songs = songs;
    }
}
