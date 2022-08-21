package com.example.mercadolibremeli.model.Interactor.Category;

import android.content.Context;
import android.util.Log;

import com.example.mercadolibremeli.adapter.ApiAdapter;
import com.example.mercadolibremeli.interfaces.category.InterfaceModel;
import com.example.mercadolibremeli.interfaces.category.InterfacePresenter;
import com.example.mercadolibremeli.model.entities.Paises;
import com.example.mercadolibremeli.rest.UtilsNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryInteractor implements InterfaceModel {

    private InterfacePresenter presenter;
    private final Context context;

    public CategoryInteractor(InterfacePresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }
    @Override
    public void querySearch(String id) {
        try {
            Call<List<Category>> listaCategorias= ApiAdapter.getApiService().getCategory(id);
            listaCategorias.enqueue(new Callback<List<Category>>() {
                @Override
                public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                    if (response.isSuccessful()) {
                        List<Category> listCategory=response.body();
                        if (listCategory != null) {
                            successfulQuery(listCategory);

                        } else {
                            Log.e("CategoryInteractor", "Response is null");
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Category>> call, Throwable t) {
                    Log.e("CategoryInteractor", "onFailure  falla el consumo"+t.toString());
                }
            });
        }catch (Exception e){
            Log.e("CategoryInteractor", "Error consumo"+e.toString());
        }
    }


    @Override
    public void getCategorias() {
        if (UtilsNetwork.isOnline(context)) {
            getCategoriasFromApi();
        }

    }

    @Override
    public void getCategoriasFromApi() {
        Call<List<Paises>> call = ApiAdapter.getDataApi().getPaises();
        call.enqueue(this);
    }
}
