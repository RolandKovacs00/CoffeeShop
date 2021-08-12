package com.example.coffeeshop.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COFFEE_ID")
    private Long id;

    @OneToOne
    private Recipe recipe;

    @ManyToOne
    private Orders order;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", recipe=" + recipe +
                ", order=" + order +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(id, coffee.id) && Objects.equals(recipe, coffee.recipe) && Objects.equals(order, coffee.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipe, order);
    }
}
