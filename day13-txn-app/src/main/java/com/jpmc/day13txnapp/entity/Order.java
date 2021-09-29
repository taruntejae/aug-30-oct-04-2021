package com.jpmc.day13txnapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ordered_item")
    private String orderedItem;

    @Column
    private String address;

    @Column(name = "ordered_quantity")
    private int orderedQuantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderedItem() {
        return orderedItem;
    }

    public void setOrderedItem(String orderedItem) {
        this.orderedItem = orderedItem;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(int orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }
}
