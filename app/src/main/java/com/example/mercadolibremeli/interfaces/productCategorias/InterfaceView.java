package com.example.mercadolibremeli.interfaces.productCategorias;

import com.example.mercadolibremeli.model.entities.Product;

import java.util.ArrayList;

public interface InterfaceView {

    void getProductCategorias(String id_pais, String id_categoria);

    void showProgresBar();

    void hideProgresBar();

    void showProductCategorias(ArrayList<Product> productos);

}
