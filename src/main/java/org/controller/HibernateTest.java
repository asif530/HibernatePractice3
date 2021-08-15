package org.controller;

import org.dto.Address;
import org.dto.Songs;
import org.dto.UserDetails;
import org.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * Continuation of hibernate 13
 * Here in place of collection we will use entity
 * */

public class HibernateTest {
    public static void main(String[] args) {

        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("First User");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        Songs songs = new Songs();

        songs.setsName("Hoist the colours");
        songs.setSource("Pirates of the Seas");

        userDetails.setVehicle(vehicle);
        //userDetails.setSongs(songs);
        songs.setUserDetails(userDetails);
        //Put the entity in vehicle class...And put @OneToOne there...We will have two tables who has keys of each other.
        //Comment vehicle's userDetails and following code
        //vehicle.setUserDetails(userDetails);
        /*
        * Q1. After doing userDetails.setVehicle(vehicle)  Do we still need this code? --> session.save(vehicle);
        * A1. Yes we need the code cause if commented or removed we will get  ''org.hibernate.TransientObjectException'' error...Cause hibernate will try to create and insert value
        *     in the vehicle table of database. And when it will not find anything it will throw this error. And will not insert any value to any table.
        * Q2. Why do we need to do userDetails.setVehicle(vehicle)????
        * A2. If we dont do this we will not get any error but userDetails will have no knowledge about the vehicle class...So the mapping wont be created.
         * */

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(userDetails);
        session.save(vehicle);
        session.save(songs);

        session.getTransaction().commit();

        userDetails = (UserDetails)session.get(UserDetails.class,1);
        session.close();
    }
}
