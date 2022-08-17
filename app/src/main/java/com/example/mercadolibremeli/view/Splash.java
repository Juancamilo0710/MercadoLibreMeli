package com.example.mercadolibremeli.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.mercadolibremeli.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
            new Handler().postDelayed(() -> {
                Log.i("SplashScreen", "Inicio app");
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                finish();
            },2000);
    }
}