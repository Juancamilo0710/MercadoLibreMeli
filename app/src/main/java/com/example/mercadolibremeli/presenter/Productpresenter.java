package com.example.mercadolibremeli.presenter;

import android.content.Context;

import com.example.mercadolibremeli.interfaces.product.InterfaceModel;
import com.example.mercadolibremeli.interfaces.product.InterfacePresenter;
import com.example.mercadolibremeli.interfaces.product.InterfaceView;
import com.example.mercadolibremeli.model.Interactor.Product.ProductInteractor;
import com.example.mercadolibremeli.model.entities.Product;

import java.util.ArrayList;

public class Productpresenter implements InterfacePresenter {

    private InterfaceView view;
    private InterfaceModel intector;

    public Productpresenter(InterfaceView view, Context context){
        this.view = view;
        intector = new ProductInteractor(this, context);
    }

    @Override
    public void getData(String q) {
        intector.getData(q);
    }

    @Override
    public void showProduct(ArrayList<Product> productos) {
        view.showProduct(productos);
    }
}
