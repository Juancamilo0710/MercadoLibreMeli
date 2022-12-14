package com.example.mercadolibremeli.model.Interactor.Categorias;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.mercadolibremeli.adapter.ApiAdapter;
import com.example.mercadolibremeli.interfaces.categorias.InterfaceModel;
import com.example.mercadolibremeli.interfaces.categorias.InterfacePresenter;
import com.example.mercadolibremeli.model.entities.Categorias;
import com.example.mercadolibremeli.rest.UtilsNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriasInteractor implements InterfaceModel, Callback<List<Categorias>> {

    private final Context context;
    private InterfacePresenter presenter;

    public CategoriasInteractor(InterfacePresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }

    @Override
    public void getCategorias(String id_pais) {
        if (UtilsNetwork.isOnline(context)) {
            getCategoriasFromApi(id_pais);
        } else {
            presenter.showUtilsNetwork();
            Toast.makeText(context, "Verifique su conexión a internet", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getCategoriasFromApi(String id_pais) {
        Call<List<Categorias>> call = ApiAdapter.getDataApi().getCategorias(id_pais);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Categorias>> call, Response<List<Categorias>> response) {
        if (response.isSuccessful()) {
            List<Categorias> listCategory = response.body();
            if (listCategory != null) {
                Log.i("CategoriasInteractor", "Retorna lista a la Vista");
                presenter.showCategorias(listCategory);
            } else {
                Log.e("CategoriasInteractor", "No encontro lista para retornar a la vista");
            }
        }

    }

    @Override
    public void onFailure(Call<List<Categorias>> call, Throwable t) {
        Log.e("CategoriasInteractor", "Fallo el consumo");
    }
}
