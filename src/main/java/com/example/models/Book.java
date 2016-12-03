package com.example.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ctola
 */
@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHORID")
    private Author author;

    public Book() {

    }

    public Book(Long id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "Book: { id: " + id +
                ", title: " + title +
                ", author: " + author.getId() + " }";
    }
}
