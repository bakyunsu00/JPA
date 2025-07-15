package com.example.demo.itemType;


import jakarta.persistence.Entity;

@Entity
public class movie extends Item {
    private String director;
    private String actor;


}
