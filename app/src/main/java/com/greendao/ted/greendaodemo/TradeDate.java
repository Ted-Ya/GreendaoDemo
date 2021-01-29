package com.greendao.ted.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TradeDate implements Serializable {

    @Id(autoincrement = true)
    private Long id = null;
    private String item;
    private int price;

    private static final long serialVersionUID =1L;
    public TradeDate(String item, int price) {
        this.item = item;
        this.price = price;
    }

    @Keep
    public TradeDate(Long id, String item, int price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }

    @Keep
    public TradeDate() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
