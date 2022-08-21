package com.example.mercadolibremeli.presenter.paises;

import android.content.Context;

import com.example.mercadolibremeli.interfaces.paises.InterfaceModel;
import com.example.mercadolibremeli.interfaces.paises.InterfacePresenter;
import com.example.mercadolibremeli.interfaces.paises.InterfaceView;
import com.example.mercadolibremeli.model.Interactor.paises.PaisesInteractor;
import com.example.mercadolibremeli.model.entities.Paises;

import java.util.List;

public class PaisesPresenter implements InterfacePresenter {

    private InterfaceModel interfaceModel;
    private InterfaceView view;

    public PaisesPresenter(InterfaceView view, Context context) {
        this.interfaceModel = new PaisesInteractor(this, context);
        this.view = view;
    }

    @Override
    public void showPaises(List<Paises> paises) {
        view.showPaises(paises);
        view.hideProgresBar();

    }

    @Override
    public void getPaises() {
        interfaceModel.getPaises();
        view.showProgresBar();

    }

}
