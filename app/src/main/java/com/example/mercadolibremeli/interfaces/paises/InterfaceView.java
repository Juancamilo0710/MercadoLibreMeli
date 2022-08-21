package com.example.mercadolibremeli.interfaces.paises;

import com.example.mercadolibremeli.model.entities.Paises;

import java.util.List;

public interface InterfaceView {

    void getPaises();

    void showProgresBar();

    void hideProgresBar();

    void showPaises(List<Paises> countries);

}
