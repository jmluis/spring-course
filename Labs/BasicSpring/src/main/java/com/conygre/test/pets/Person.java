package com.conygre.test.pets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nick Todd on 03/04/2017.
 */

public class Person {

    private Pet pet;
    private Address address;
    
    public Person(Pet pet, Address address) {
        this.pet = pet;
        this.address = address;
    }
    
    public Person(Pet pet) {
        this(pet, null);
    }

    public Person(Address address) {
        this(null, address);
    }


    public Person(){}

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
