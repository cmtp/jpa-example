package com.example.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ctola
 */
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TOWN")
    private String town;

    @Column(name = "COUNTRY")
    private String country;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Employee employee;

    public Address() {

    }

    public Address(Long id, String address, String town, String country) {
        this.id = id;
        this.address = address;
        this.town = town;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address: { id: " + id +
                ", address: " + address +
                ", town: " + town +
                ", country: " + country +
                ", employee: " + employee.getCode() + " }";
    }
}
