package com.example.mercadolibremeli.interfaces.api;

import com.example.mercadolibremeli.model.entities.ListProduct;
import com.example.mercadolibremeli.rest.Endpoints;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonApi {

    @GET(Endpoints.GET_PRODUCT)
    Call<ListProduct> getListProduct(@Query("q") String q);

    @GET(Endpoints.GET_SITES)
    Call<ArrayList<ListProduct>> getRequestPost(@Query("userId") String userId);
}
