package com.example.mercadolibremeli.interfaces.paises;

import com.example.mercadolibremeli.model.entities.Paises;

import java.util.List;

public interface InterfacePresenter {

    void getPaises();

    void showPaises(List<Paises> countries);

    void showUtilsNetwork();

}
