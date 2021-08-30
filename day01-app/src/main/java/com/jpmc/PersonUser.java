package com.jpmc;

public class PersonUser {
    public static void main(String[] args) {
        
        // Unnecessary creation code
        Person sam = new Person();
        sam.setName("Sam");

        Car bmw = new Car();
        bmw.setModel("BMW");
        bmw.setYearOfMake(2020);
        sam.setCar(bmw);

        sam.driveToWork();
    }
}
