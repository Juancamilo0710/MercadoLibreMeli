package com.example.mercadolibremeli.model.Interactor.ProductCategorias;

import android.util.Log;

import com.example.mercadolibremeli.adapter.ApiAdapter;
import com.example.mercadolibremeli.interfaces.productCategorias.InterfaceModel;
import com.example.mercadolibremeli.interfaces.productCategorias.InterfacePresenter;
import com.example.mercadolibremeli.model.entities.Categorias;
import com.example.mercadolibremeli.model.entities.ListProduct;
import com.example.mercadolibremeli.model.entities.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductCategoriasInteractor implements InterfaceModel, Callback<ListProduct> {

    private InterfacePresenter presenter;

    public ProductCategoriasInteractor(InterfacePresenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void getProductCategorias(String id_pais, String id_categoria) {
        Call<ListProduct> call = ApiAdapter.getDataApi().getProductForCategory(id_pais,id_categoria);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ListProduct> call, Response<ListProduct> response) {
        ListProduct listadeproductos = response.body();
        ArrayList<Product> productos = listadeproductos.getResults();
        if(productos.size()>0) {
            presenter.showProductCategorias(productos);
        }else {
            Log.e("onResponsePC", "Response is null");
        }
    }

    @Override
    public void onFailure(Call<ListProduct> call, Throwable t) {

    }
}
