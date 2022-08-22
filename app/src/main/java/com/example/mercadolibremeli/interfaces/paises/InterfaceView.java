package com.example.mercadolibremeli.interfaces.paises;

import android.view.View;

import com.example.mercadolibremeli.model.entities.Paises;

import java.util.List;

public interface InterfaceView {

    void initV();

    void getPaises();

    void reload(View view);

    void showPaises(List<Paises> countries);

    void showprogressBar();

    void disguiseprogressBar();

    void showUtilsNetwork();

    void disguiseUtilsNetwork();

}
