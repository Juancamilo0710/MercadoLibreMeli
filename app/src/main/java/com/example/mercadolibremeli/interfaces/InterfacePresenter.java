package com.example.mercadolibremeli.interfaces;

import com.example.mercadolibremeli.model.entities.Product;

import java.util.ArrayList;

public interface InterfacePresenter {

    void getData(String q);

    void showProduct(ArrayList<Product> productos);
}
