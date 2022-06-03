package com.zzd.review;

import com.google.gson.Gson;

import java.io.Serializable;

public class BookInfo implements Serializable {
    private String name;
    private String publish;
    private String price;

    @Override
    public String toString() {
        return "BookInfo{" +
                "name='" + name + '\'' +
                ", publish='" + publish + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
