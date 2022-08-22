package com.example.mercadolibremeli.model.Interactor.ProductosCategorias;

import android.util.Log;

import com.example.mercadolibremeli.adapter.ApiAdapter;
import com.example.mercadolibremeli.interfaces.productosCategorias.InterfaceModel;
import com.example.mercadolibremeli.interfaces.productosCategorias.InterfacePresenter;
import com.example.mercadolibremeli.model.entities.ListProductos;
import com.example.mercadolibremeli.model.entities.Productos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductosCategoriasInteractor implements InterfaceModel, Callback<ListProductos> {

    private InterfacePresenter presenter;

    public ProductosCategoriasInteractor(InterfacePresenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void getProductCategorias(String id_pais, String id_categoria) {
        Call<ListProductos> call = ApiAdapter.getDataApi().getProductForCategory(id_pais,id_categoria);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ListProductos> call, Response<ListProductos> response) {
        ListProductos listadeproductos = response.body();
        ArrayList<Productos> productos = listadeproductos.getResults();
        if(productos.size()>0) {
            presenter.showProductCategorias(productos);
        }else {
            Log.e("onResponsePC", "Response is null");
        }
    }

    @Override
    public void onFailure(Call<ListProductos> call, Throwable t) {

    }
}