package com.example.mercadolibremeli.model.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    private int available_quantity;
    private float price;
    private String title;
    private String thumbnail;
    private ArrayList<AtributosProduct> attributes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }

    public ArrayList<AtributosProduct> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<AtributosProduct> attributes) {
        this.attributes = attributes;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
