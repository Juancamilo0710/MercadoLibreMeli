package com.example.mercadolibremeli.interfaces.productos;

import com.example.mercadolibremeli.model.entities.Productos;

import java.util.ArrayList;

public interface InterfaceView {

    void initV();

    void getData(String q);

    void showProduct(ArrayList<Productos> productos);

}
