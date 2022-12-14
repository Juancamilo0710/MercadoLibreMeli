package com.example.mercadolibremeli.model.Interactor.paises;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.mercadolibremeli.adapter.ApiAdapter;
import com.example.mercadolibremeli.interfaces.paises.InterfaceModel;
import com.example.mercadolibremeli.interfaces.paises.InterfacePresenter;
import com.example.mercadolibremeli.model.entities.Paises;
import com.example.mercadolibremeli.rest.UtilsNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaisesInteractor implements InterfaceModel, Callback<List<Paises>> {

    private InterfacePresenter presenter;
    private final Context context;

    public PaisesInteractor(InterfacePresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;

    }

    @Override
    public void getPaises() {
        if (UtilsNetwork.isOnline(context)) {
            getPaisesFromApi();
        } else {
            presenter.showUtilsNetwork();
            Toast.makeText(context, "Verifique su conexión a internet", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getPaisesFromApi() {
        Call<List<Paises>> call = ApiAdapter.getDataApi().getPaises();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Paises>> call, Response<List<Paises>> response) {
        if (response.isSuccessful()) {
            List<Paises> listCountry=response.body();
            if (listCountry != null) {
                Log.i("PaisesInteractor", "Retorna lista a la Vista");
                presenter.showPaises(listCountry);
            } else {
                Log.e("PaisesInteractor", "No encontro lista para retornar a la vista");
            }
        }
    }

    @Override
    public void onFailure(Call<List<Paises>> call, Throwable t) {
        Log.e("ProductosInteractor", "Fallo el consumo");
    }
}
