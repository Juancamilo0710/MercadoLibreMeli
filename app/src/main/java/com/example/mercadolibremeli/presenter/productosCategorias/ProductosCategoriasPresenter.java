package com.example.mercadolibremeli.presenter.productosCategorias;

import android.content.Context;

import com.example.mercadolibremeli.interfaces.productosCategorias.InterfaceModel;
import com.example.mercadolibremeli.interfaces.productosCategorias.InterfacePresenter;
import com.example.mercadolibremeli.interfaces.productosCategorias.InterfaceView;
import com.example.mercadolibremeli.model.Interactor.ProductosCategorias.ProductosCategoriasInteractor;
import com.example.mercadolibremeli.model.entities.Productos;

import java.util.ArrayList;

public class ProductosCategoriasPresenter implements InterfacePresenter {


    private InterfaceModel productInterator;
    private InterfaceView view;
    private Context context;


    public ProductosCategoriasPresenter(InterfaceView view, Context context) {
        this.productInterator = new ProductosCategoriasInteractor(this, context);
        this.view = view;
        this.context = context;
    }

    @Override
    public void getProductCategorias(String id_pais, String id_categoria) {
        productInterator.getProductCategorias( id_pais, id_categoria);
    }

    @Override
    public void showProductCategorias(ArrayList<Productos> productos) {
        view.disguiseProgresBar();
        view.showProductCategorias(productos);
    }

    @Override
    public void showUtilsNetwork() {
        view.disguiseProgresBar();
        view.showUtilsNetwork();
    }


}
