package com.TransportationSystem.database;

import com.TransportationSystem.Model.Transportation;
import com.TransportationSystem.entity.Customer;
import com.TransportationSystem.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
public class TransportationDBOperation {
    public SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Vehicle.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
    public void storeData(Transportation transportation, SessionFactory sessionFactory) {
        Customer customer = new Customer(transportation.getCustId(), transportation.getCustName(),
                transportation.getMob(), transportation.getEmail(), transportation.getDurationForRent(),
                transportation.getTotalCalculatedRentAmt());
        Vehicle vehicle = new Vehicle(transportation.getVehicleId(), transportation.getTypeOfVehicle(),
                transportation.getMileageOfVehicle(), transportation.getGearType(), transportation.getCustId());
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(customer);
            session.save(vehicle);
            session.getTransaction().commit();

        } catch(Exception e) {
            System.err.println("Error details ::" +e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public void displayStoredData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();

        try {
            String hql = "FROM Customer";
            Query query = session.createQuery(hql);
            List<Customer> customers = query.list();
            System.out.println(customers);

            String hql1 = "FROM Vehicle";
            Query query1 = session.createQuery(hql1);
            List<Vehicle> vehicles = query1.list();
            System.out.println(vehicles);

        } catch(Exception e) {
            System.err.println("Error details ::" +e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}