package com.jpmc.misc.persons;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {

    @EmbeddedId
    private PersonKey personKey;

    @Column
    private int age;

    public PersonKey getPersonKey() {
        return personKey;
    }

    public void setPersonKey(PersonKey personKey) {
        this.personKey = personKey;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
