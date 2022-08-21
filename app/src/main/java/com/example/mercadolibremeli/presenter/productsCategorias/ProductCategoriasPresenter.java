package com.example.mercadolibremeli.presenter.productsCategorias;

import android.content.Context;

import com.example.mercadolibremeli.interfaces.productCategorias.InterfaceModel;
import com.example.mercadolibremeli.interfaces.productCategorias.InterfacePresenter;
import com.example.mercadolibremeli.interfaces.productCategorias.InterfaceView;
import com.example.mercadolibremeli.model.Interactor.ProductCategorias.ProductCategoriasInteractor;
import com.example.mercadolibremeli.model.entities.Product;

import java.util.ArrayList;

public class ProductCategoriasPresenter implements InterfacePresenter {


    private InterfaceModel productInterator;
    private InterfaceView view;


    public ProductCategoriasPresenter(InterfaceView view, Context context) {
        this.productInterator = new ProductCategoriasInteractor(this);
        this.view = view;
    }

    @Override
    public void getProductCategorias(String id_pais, String id_categoria) {
        productInterator.getProductCategorias( id_pais, id_categoria);
        view.showProgresBar();
    }

    @Override
    public void showProductCategorias(ArrayList<Product> productos) {
        view.hideProgresBar();
        view.showProductCategorias(productos);
    }


}
