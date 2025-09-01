package com.example.demo.service;

import com.example.demo.Delivery;
import com.example.demo.Member;
import com.example.demo.Order;
import com.example.demo.OrderItem;
import com.example.demo.itemType.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class OrderService {


    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;


    @Transactional
    public Long order(Long itemId, Long memberId, int count){
        Item item = itemRepository.findOne(itemId);
        Member member = memberRepository.find(memberId);
        Delivery delivery = new Delivery();



        OrderItem orderItem = OrderItem.createOrderItem(item,item.getPrice(),count);
        Order order = Order.creatOrder(member,delivery,orderItem);

        orderRepository.save(order);
        return order.getId();

    }

    @Transactional
    public void cancelOrder(Long orderId){
        Order cancelingOrder = orderRepository.findOne(orderId);
        cancelingOrder.cancel();
    }

}
