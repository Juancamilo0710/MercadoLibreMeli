package com.example.mercadolibremeli.interfaces.productosCategorias;

import android.view.View;

import com.example.mercadolibremeli.model.entities.Productos;

import java.util.ArrayList;

public interface InterfaceView {

    void initV();

    void getProductCategorias(String id_pais, String id_categoria);

    void showProgresBar();

    void disguiseProgresBar();

    void showProductCategorias(ArrayList<Productos> productos);

    void showUtilsNetwork();

    void disguiseUtilsNetwork();

    void reload(View view);

}
