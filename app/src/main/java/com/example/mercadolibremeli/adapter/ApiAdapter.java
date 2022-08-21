package com.example.mercadolibremeli.adapter;


import com.example.mercadolibremeli.interfaces.api.JsonApi;
import com.example.mercadolibremeli.rest.Endpoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    private ApiAdapter(){

    }

    private static JsonApi jsonApi;

    public static JsonApi getDataApi() {
        if (jsonApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Endpoints.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            jsonApi = retrofit.create(JsonApi.class);
        }
        return jsonApi;
    }
}
