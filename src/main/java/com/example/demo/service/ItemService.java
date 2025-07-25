package com.example.demo.service;

import com.example.demo.itemType.Item;
import com.example.demo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public Item findOneItem(Item item){
        return itemRepository.findOne(item);
    }

    public List<Item> findAllItem(){
        return itemRepository.findAll();
    }




}
