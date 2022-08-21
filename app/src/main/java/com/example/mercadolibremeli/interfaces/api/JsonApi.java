package com.example.mercadolibremeli.interfaces.api;

import com.example.mercadolibremeli.model.entities.Categorias;
import com.example.mercadolibremeli.model.entities.ListProduct;
import com.example.mercadolibremeli.model.entities.Paises;
import com.example.mercadolibremeli.rest.Endpoints;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonApi {

    @GET(Endpoints.GET_PRODUCT)
    Call<ListProduct> getListProduct(@Query("q") String q);

    @GET(Endpoints.GET_SITES)
    Call<List<Paises>> getPaises();

    @GET(Endpoints.GET_CATEGORIASCOUNTRY)
    Call<List<Categorias>> getCategorias(@Path("id") String id);

    @GET(Endpoints.GET_SITES)
    Call<ArrayList<ListProduct>> getRequestPost(@Query("userId") String userId);

    @GET(Endpoints.GET_PRODUCTSFORCATEGORY)
    Call<ListProduct> getProductForCategory(@Path("id_pais") String id_pais,@Query("category") String category);
}
