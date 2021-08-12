package com.example.coffeeshop.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDERS_ID")
    private Long id;

    private BigDecimal amount;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDERS_ID")
    private List<Coffee> coffees = new ArrayList<Coffee>();

    @ManyToOne
    private Customer customers;

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", coffees=" + coffees +
                ", customers=" + customers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders order = (Orders) o;
        return Objects.equals(id, order.id) && Objects.equals(amount, order.amount) && Objects.equals(coffees, order.coffees) && Objects.equals(customers, order.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, coffees, customers);
    }
}
