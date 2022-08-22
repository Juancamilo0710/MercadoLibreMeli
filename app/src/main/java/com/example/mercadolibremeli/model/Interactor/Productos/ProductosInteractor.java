package com.example.mercadolibremeli.model.Interactor.Productos;

import android.content.Context;
import android.widget.Toast;

import com.example.mercadolibremeli.adapter.ApiAdapter;
import com.example.mercadolibremeli.interfaces.productos.InterfaceModel;
import com.example.mercadolibremeli.interfaces.productos.InterfacePresenter;
import com.example.mercadolibremeli.model.entities.ListProductos;
import com.example.mercadolibremeli.model.entities.Productos;
import com.example.mercadolibremeli.rest.UtilsNetwork;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductosInteractor implements InterfaceModel, Callback<ListProductos> {

    private final InterfacePresenter presenter;
    private final Context context;

    public ProductosInteractor(InterfacePresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }


    @Override
    public void getproductFromApi(String q) {
        Call<ListProductos> call = ApiAdapter.getDataApi().getListProduct(q);
        call.enqueue(this);
    }

    @Override
    public void getData(String q) {
        if (UtilsNetwork.isOnline(context)) {
            getproductFromApi(q);
        } else {
            presenter.showUtilsNetwork();
            Toast.makeText(context, "Verifique su conexión a internet", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onResponse(Call<ListProductos> call, Response<ListProductos> response) {
        if (response.isSuccessful()) {
            ListProductos listProductos = response.body();
            ArrayList<Productos> listProductosModelImps = listProductos.getResults();
            if(listProductosModelImps != null && !listProductosModelImps.isEmpty()){
                presenter.showProduct(listProductosModelImps);
            } else {
                presenter.showFailProductos();
            }
        }
    }

    @Override
    public void onFailure(Call<ListProductos> call, Throwable t) {

    }
}
