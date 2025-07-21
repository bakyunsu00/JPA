package com.example.demo.repository;

import com.example.demo.itemType.Item;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private EntityManager em;


    public void save(Item item){
        if(item.getId() == null){
            em.persist(item);
        }else{
            em.merge(item);
        }
    }

    public Item findOne(Item item){
        return em.find(Item.class, item.getId());
    }

    public List<Item> findAll(){
//        TypedQuery<Item> query =  em.createQuery("select i from Item i",Item.class);
//        List<Item> result = query.getResultList();
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }









}
