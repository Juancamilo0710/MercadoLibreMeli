package com.example.mercadolibremeli.model.Interactor.ProductosCategorias;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.mercadolibremeli.adapter.ApiAdapter;
import com.example.mercadolibremeli.interfaces.productosCategorias.InterfaceModel;
import com.example.mercadolibremeli.interfaces.productosCategorias.InterfacePresenter;
import com.example.mercadolibremeli.model.entities.ListProductos;
import com.example.mercadolibremeli.model.entities.Productos;
import com.example.mercadolibremeli.rest.UtilsNetwork;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductosCategoriasInteractor implements InterfaceModel, Callback<ListProductos> {

    private InterfacePresenter presenter;
    private Context context;

    public ProductosCategoriasInteractor(InterfacePresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }

    @Override
    public void getProductCategorias(String id_pais, String id_categoria) {
        if (UtilsNetwork.isOnline(context)) {
            getProductCategoriasFromApi(id_pais, id_categoria);
        } else {
            presenter.showUtilsNetwork();
            Toast.makeText(context, "Verifique su conexión a internet", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void getProductCategoriasFromApi(String id_pais, String id_categoria) {
        Call<ListProductos> call = ApiAdapter.getDataApi().getProductForCategory(id_pais,id_categoria);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ListProductos> call, Response<ListProductos> response) {
        ListProductos listadeproductos = response.body();
        ArrayList<Productos> productos = listadeproductos.getResults();
        if(productos.size()>0) {
            Log.i("ProductosCategorias", "Retorna lista a la Vista");
            presenter.showProductCategorias(productos);
        } else {
            Log.e("ProductosCategorias", "No encontro lista para retornar a la vista");
        }
    }

    @Override
    public void onFailure(Call<ListProductos> call, Throwable t) {
        Log.e("ProductosCategorias", "Fallo el consumo");
    }
}
