package com.example.demo.itemType;


import com.example.demo.Category;

import com.example.demo.execptions.NotEnoughStockExecption;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item {




    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;


    private String name;
    private int price;
    private int stockQuantity;

    //private List<Category> categories;

    public void addQuantity(int number){
        this.stockQuantity += number;
    }

    public void removeQuantity(int number){
        int restQuantity = this.stockQuantity - number;
        if(restQuantity < 0 ){
            throw new NotEnoughStockExecption("재고가 없습니다.");
        }else{
            this.stockQuantity = restQuantity;
        }
    }












}
