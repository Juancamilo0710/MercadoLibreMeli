package com.example.mercadolibremeli.presenter.categorias;


import android.content.Context;

import com.example.mercadolibremeli.interfaces.categorias.InterfaceModel;
import com.example.mercadolibremeli.interfaces.categorias.InterfacePresenter;
import com.example.mercadolibremeli.interfaces.categorias.InterfaceView;
import com.example.mercadolibremeli.model.Interactor.Categorias.CategoriasInteractor;
import com.example.mercadolibremeli.model.entities.Categorias;

import java.util.List;

public class CategoriasPresenter implements InterfacePresenter {


    private InterfaceModel interfaceModel;
    private InterfaceView view;

    public CategoriasPresenter(InterfaceView view, Context context) {
        this.interfaceModel = new CategoriasInteractor(this, context);
        this.view = view;
    }

    @Override
    public void getCategorias(String id_pais) {
        interfaceModel.getCategorias(id_pais);
        view.showProgresBar();
    }

    @Override
    public void showCategorias(List<Categorias> categorias) {
        view.showCategorias(categorias);
    }
}
