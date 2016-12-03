package com.example.test;

import com.example.models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author ctola
 */
public class TestEmployees {

    //@PersistenceContext(unitName = "Persistence")
    private static EntityManager manager;

    private static EntityManagerFactory emf;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("Persistence");
        manager = emf.createEntityManager();

        List<Employee> employees = (List<Employee>) manager.createQuery("FROM Employee").getResultList();
        System.out.println("In this database exists " + employees.size() + " employees.");
    }
}
