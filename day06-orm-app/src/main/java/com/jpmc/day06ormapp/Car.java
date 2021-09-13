package com.jpmc.day06ormapp;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    private int id;
    @Column
    private String model;
    @Column
    private int year;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Car(int id, String model, int year) {
        this.id = id;
        this.model = model;
        this.year = year;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
