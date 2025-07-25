package com.example.demo;


import lombok.Getter;

import jakarta.persistence.*;

@Entity
@Getter

public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;


    private Address address;
    private DeliveryStatus deliveryStatus;

    protected void setOrder(Order order){
        this.order = order;
    }

    protected void setDeliveryStatus(DeliveryStatus deliveryStatus){ this.deliveryStatus = deliveryStatus;}




}
