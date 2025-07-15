package com.example.demo;


import com.example.demo.itemType.Item;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter

public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "orderItem_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private int count;







}
