package com.example.models;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author ctola
 */

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="CODE")
    private Long code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "DATE")
    private LocalDate date;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "ADDRESSID")
    private Address address;

    public Employee() {

    }

    public Employee(Long code, String name, String lastname, LocalDate date) {
        this.code = code;
        this.name = name;
        this.lastname = lastname;
        this.date = date;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee: { code: " + code +
                ", name: " + name +
                ", lastname: " + lastname +
                ", date: " + date +
                ", address: " + address + " }";
    }
}
