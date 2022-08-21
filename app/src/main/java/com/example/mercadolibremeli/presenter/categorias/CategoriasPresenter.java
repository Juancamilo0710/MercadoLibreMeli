package com.example.mercadolibremeli.presenter.Category;


import android.content.Context;

import com.example.mercadolibremeli.interfaces.category.InterfaceModel;
import com.example.mercadolibremeli.interfaces.category.InterfacePresenter;
import com.example.mercadolibremeli.interfaces.category.InterfaceView;
import com.example.mercadolibremeli.model.Interactor.Category.CategoryInteractor;
import com.example.mercadolibremeli.model.entities.Category;

import java.util.List;

public class CategoryPresenter implements InterfacePresenter {


    private InterfaceModel interfaceModel;
    private InterfaceView view;

    public CategoryPresenter(InterfaceView view, Context context) {
        this.interfaceModel = new CategoryInteractor(this, context);
        this.view = view;
    }

    @Override
    public void getCategorias() {
        interfaceModel.getCategorias();
        view.showProgresBar();
    }
}
