package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;


    private LocalDateTime orderData;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    // 연관관계 메서드
    private void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);

    }

    private void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    private void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    private void setOrderStatus(OrderStatus orderStatus){
        this.orderStatus = orderStatus;
    }

    private void setLocaDataTime(LocalDateTime orderData){
        this.orderData = orderData;

    }
    //생성 메서드

    public static Order creatOrder(Member member, Delivery delivery, OrderItem... orderItems)
    {
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for(OrderItem orderItem:orderItems){
            order.addOrderItem(orderItem);
        }
        order.setLocaDataTime(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.ORDER);
        return order;
    }

    // 비지니스 로직
    /*
    주문 취소
     */

    public void cancel(){
        if(delivery.getDeliveryStatus() == DeliveryStatus.COMP){
            throw new IllegalArgumentException("이미 배송 완료된 주문입니다.");
        }else{
            this.orderStatus = OrderStatus.CANCEL;
            for(OrderItem orderItem: orderItems){
                orderItem.cancel();
            }
        }
    }


    /**
     *
     * 전체 총액 조회
     */
    public int getTotalPrice(){
        int totalPrice = 0;
        for(OrderItem orderItem: orderItems){
          totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }

        }












