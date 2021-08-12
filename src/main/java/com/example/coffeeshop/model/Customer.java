package com.example.coffeeshop.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private Long id;

    private String name;
    private boolean cash;
    private String card_number;
    private Integer CVV;
    private Date date_card;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private List<Orders> orders = new ArrayList<Orders>();

    @ManyToOne
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public boolean getCash() {
        return cash;
    }

    public void setCash(boolean cash) {
        this.cash = cash;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public Integer getCVV() {
        return CVV;
    }

    public void setCVV(Integer CVV) {
        this.CVV = CVV;
    }

    public Date getDate() {
        return date_card;
    }

    public void setDate(Date date_card) {
        this.date_card = date_card;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cash=" + cash +
                ", card_number='" + card_number + '\'' +
                ", CVV=" + CVV +
                ", date_card=" + date_card +
                ", orders=" + orders +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return cash == customer.cash && Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(card_number, customer.card_number) && Objects.equals(CVV, customer.CVV) && Objects.equals(date_card, customer.date_card) && Objects.equals(orders, customer.orders) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cash, card_number, CVV, date_card, orders, address);
    }
}
