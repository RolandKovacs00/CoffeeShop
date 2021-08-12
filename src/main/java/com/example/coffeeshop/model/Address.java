package com.example.coffeeshop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID")
    private Long id;

    private String street;
    private Long nr;
    private String locality;
    private String city;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    private List<Customer> customers = new ArrayList<Customer>();

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getNr() {
        return nr;
    }

    public void setNr(Long nr) {
        this.nr = nr;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + nr +
                ", locality='" + locality + '\'' +
                ", city='" + city + '\'' +
                ", customers=" + customers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(nr, address.nr) && Objects.equals(locality, address.locality) && Objects.equals(city, address.city) && Objects.equals(customers, address.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, nr, locality, city, customers);
    }
}
