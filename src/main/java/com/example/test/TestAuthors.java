package com.example.test;

import com.example.models.Author;
import com.example.models.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author ctola
 */
public class TestAuthors {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");

    public static void main(String[] args) {
        createData();
        printData();
    }
    public static void createData() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Author a1 = new Author(1L, "Juan Perez", "Espaniola");
        Author a2 = new Author(2L, "Juancito Perez", "Mexico");
        Author a3 = new Author(3L, "Armando Escalera", "Boliviano");
        em.persist(a1);
        em.persist(a2);
        em.persist(a3);

        em.persist(new Book(1L, "Welcome to Portal", a2));
        em.persist(new Book(2L, "Welcome to Bolivia", a3));
        em.persist(new Book(3L, "Welcome to the jungle", a1));
        em.persist(new Book(4L, "Welcome to the city", a2));
        em.persist(new Book(5L, "Welcome to web program", a2));

        em.getTransaction().commit();

        em.close();
    }

    public static void printData() {
        EntityManager em = emf.createEntityManager();
        Author a2 = em.find(Author.class, 2L);
        List<Book> books = a2.getBooks();
        for (Book b: books) {
            System.out.println("* " + b.toString());
        }
        System.out.println(a2);
        em.close();
    }
}
