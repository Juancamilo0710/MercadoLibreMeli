package com.example.mercadolibremeli.rest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class UtilsNetwork {

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager != null){
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo != null){
                Log.i("UtilsNetwork", "Hay Conexión a Internet");
                return networkInfo.isConnected();
            }
        }
        Log.e("UtilsNetwork", "No hay Conexión a Internet");
        return false;
    }
}
