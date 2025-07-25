package com.example.demo;


import com.example.demo.itemType.Item;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue
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

    private int totalPrice;

    protected void setOrder(Order order) {
        this.order = order;
    }

    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setCount(count);
        orderItem.setOrderPrice(orderPrice);
        item.removeQuantity(count);

        return orderItem;


    }


    public void cancel() {
        getItem().addQuantity(count);

    }


    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}


