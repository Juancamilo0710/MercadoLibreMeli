package com.example.mercadolibremeli.model.Interactor.Product;

import android.content.Context;
import android.widget.Toast;

import com.example.mercadolibremeli.adapter.ApiAdapter;
import com.example.mercadolibremeli.interfaces.InterfaceModel;
import com.example.mercadolibremeli.interfaces.InterfacePresenter;
import com.example.mercadolibremeli.model.entities.ListProduct;
import com.example.mercadolibremeli.model.entities.Product;
import com.example.mercadolibremeli.rest.UtilsNetwork;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductInteractor implements InterfaceModel, Callback<ListProduct> {

    private final InterfacePresenter presenter;
    private final Context context;

    public ProductInteractor(InterfacePresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }

    @Override
    public void getUsersFromApi(String q) {
        Call<ListProduct> call = ApiAdapter.getDataUser().getListProduct(q);
        call.enqueue(this);
    }

    @Override
    public void getData(String q) {
        if (UtilsNetwork.isOnline(context)) {
            getUsersFromApi(q);
        }

    }

    @Override
    public void onResponse(Call<ListProduct> call, Response<ListProduct> response) {
        if (response.isSuccessful()) {
            ListProduct listProduct = response.body();
            ArrayList<Product> listProductModelImps = listProduct.getResults();
            if(listProductModelImps != null){
                presenter.showProduct(listProductModelImps);
                Toast.makeText(context, "Consumio API...", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onFailure(Call<ListProduct> call, Throwable t) {

    }
}
