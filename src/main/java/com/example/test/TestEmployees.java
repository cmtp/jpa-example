package com.example.test;

import com.example.models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.GregorianCalendar;
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

        Employee e = new Employee(10L, "Pepito", "Perez", new GregorianCalendar(1979, 6, 6).getTime());
        Employee e2 = new Employee(25L, "Jose", "Perez", new GregorianCalendar(1984, 6, 6).getTime());
        Employee e3 = new Employee(30L, "Juan", "Perez", new GregorianCalendar(2000, 6, 6).getTime());
        manager.getTransaction().begin();
        manager.persist(e);
        manager.persist(e2);
        manager.persist(e3);
        manager.getTransaction().commit();

        printAll();
    }

    @SuppressWarnings("unchecked")
    private static void printAll() {
        List<Employee> emps = (List<Employee>) manager.createQuery("FROM Employee").getResultList();
        System.out.println("Exist " + emps.size() + " employees in the system.");
        for (Employee emp: emps) {
            System.out.println(emp.toString());
        }
    }
}
