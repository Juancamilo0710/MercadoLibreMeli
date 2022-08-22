package com.example.mercadolibremeli.presenter.productos;

import android.content.Context;

import com.example.mercadolibremeli.interfaces.productos.InterfaceModel;
import com.example.mercadolibremeli.interfaces.productos.InterfacePresenter;
import com.example.mercadolibremeli.interfaces.productos.InterfaceView;
import com.example.mercadolibremeli.model.Interactor.Productos.ProductosInteractor;
import com.example.mercadolibremeli.model.entities.Productos;

import java.util.ArrayList;

public class Productospresenter implements InterfacePresenter {

    private InterfaceView view;
    private InterfaceModel intector;

    public Productospresenter(InterfaceView view, Context context){
        this.view = view;
        intector = new ProductosInteractor(this, context);
    }

    @Override
    public void getData(String q) {
        intector.getData(q);
    }

    @Override
    public void showProduct(ArrayList<Productos> productos) {
        view.showProduct(productos);
    }
}
