package com.example.dala.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    public Passenger() {
    }
    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    
    
    

    

}
