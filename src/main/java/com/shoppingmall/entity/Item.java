package com.shoppingmall.entity;

import com.shoppingmall.constant.ItemSellStatus;
import com.shoppingmall.dto.ItemFormDto;
import com.shoppingmall.exception.OutOfStockException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity {
    
    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.AUTO) // 고정값
    private Long id; //상품번호

    @Column(nullable = false, length = 50)
    private String itemName; //상품이름

    @Column(name="price", nullable = false)
    private int price; //상품가격

    @Column(nullable = false)
    private int stockQuantity; //재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail; //상품설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; //상품판매상태

    public void updateItem(ItemFormDto itemFormDto){
        this.itemName = itemFormDto.getItemName();
        this.price = itemFormDto.getPrice();
        this.stockQuantity = itemFormDto.getStockQuantity();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }

    public void removeStock(int stockQuantity){
        int restStock = this.stockQuantity - stockQuantity;
        if(restStock < 0){
            throw new OutOfStockException("상품의 재고가 부족합니다. (현재 재고 수량: " + this.stockQuantity + ")");
        }
        this.stockQuantity = restStock;
    }

    public void addStock(int stockQuantity){
        this.stockQuantity += stockQuantity;
    }

}
