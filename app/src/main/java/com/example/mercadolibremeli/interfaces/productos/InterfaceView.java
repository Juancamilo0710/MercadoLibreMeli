package com.example.mercadolibremeli.interfaces.productos;

import android.view.View;

import com.example.mercadolibremeli.model.entities.Productos;

import java.util.ArrayList;

public interface InterfaceView {

    void initV();

    void getData(String q);

    void showProduct(ArrayList<Productos> productos);

    void showUtilsNetwork();

    void disguiseUtilsNetwork();

    void reload(View view);

    void showImagen();

    void disguiseImagen();

    void showProgresBar();

    void disguiseProgresBar();

    void showFailProductos();

    void disguiseFailProductos();

}
