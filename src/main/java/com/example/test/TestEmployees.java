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

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        EntityManager manager = emf.createEntityManager();
        insertInit();

        printAll();

        manager.getTransaction().begin();
        Employee e = manager.find(Employee.class, 10L);
        e.setName("David");
        e.setLastname("Lopez");
        manager.getTransaction().commit();

        printAll();
    }

    private static void insertInit() {
        EntityManager manager = emf.createEntityManager();
        Employee e = new Employee(10L, "Pepito", "Perez", new GregorianCalendar(1979, 6, 6).getTime());
        manager.getTransaction().begin();
        manager.persist(e);
        manager.getTransaction().commit();
        manager.close();

        printAll();

        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        e.setName("Juan");
        manager.getTransaction().commit();
        manager.close();

        printAll();
    }

    @SuppressWarnings("unchecked")
    private static void printAll() {
        EntityManager manager = emf.createEntityManager();
        List<Employee> emps = (List<Employee>) manager.createQuery("FROM Employee").getResultList();
        System.out.println("Exist " + emps.size() + " employees in the system.");
        for (Employee emp: emps) {
            System.out.println(emp.toString());
        }
    }
}
