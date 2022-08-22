package com.example.mercadolibremeli.interfaces.productosCategorias;

import com.example.mercadolibremeli.model.entities.Productos;

import java.util.ArrayList;

public interface InterfaceView {

    void getProductCategorias(String id_pais, String id_categoria);

    void showProgresBar();

    void hideProgresBar();

    void showProductCategorias(ArrayList<Productos> productos);

}
