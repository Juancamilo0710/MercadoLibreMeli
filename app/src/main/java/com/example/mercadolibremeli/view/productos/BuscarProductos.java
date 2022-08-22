package com.example.mercadolibremeli.view.productos;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.mercadolibremeli.R;
import com.example.mercadolibremeli.interfaces.productos.InterfacePresenter;
import com.example.mercadolibremeli.interfaces.productos.InterfaceView;
import com.example.mercadolibremeli.model.entities.Productos;
import com.example.mercadolibremeli.presenter.productos.Productospresenter;
import com.example.mercadolibremeli.view.categorias.Categorias;
import com.example.mercadolibremeli.view.paises.Paises;

import java.util.ArrayList;

public class BuscarProductos extends AppCompatActivity implements InterfaceView, SearchView.OnQueryTextListener {

    private ImageView menu;
    private ImageView imagen;
    private ProgressBar progressBarr;
    private LinearLayout notnetwork;
    private LinearLayout failProductos;
    private androidx.appcompat.widget.SearchView searchView;
    private final InterfacePresenter presenter = new Productospresenter(this, BuscarProductos.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initV();
        initAllPermissions();
        searchView.setOnQueryTextListener(this);
        menu.setOnClickListener(v -> OptionsMenu());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showImagen();
        disguiseFailProductos();
        disguiseUtilsNetwork();
    }

    @Override
    public void initAllPermissions() {
        ArrayList<String> permissionGrantedList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionGrantedList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionGrantedList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionGrantedList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_SETTINGS) != PackageManager.PERMISSION_GRANTED) {
            permissionGrantedList.add(Manifest.permission.WRITE_SETTINGS);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            permissionGrantedList.add(Manifest.permission.CAMERA);
        }

        if (!permissionGrantedList.isEmpty()) {
            String[] permissionGrantedStrings = permissionGrantedList.toArray(new String[0]);
            ActivityCompat.requestPermissions(this, permissionGrantedStrings, 10000);
        }
    }

    @Override
    public void initV() {
        menu = findViewById(R.id.menu);
        imagen = findViewById(R.id.imagen);
        notnetwork = findViewById(R.id.notnetwork);
        searchView = findViewById(R.id.searchview);
        progressBarr = findViewById(R.id.progressbar_loading);
        failProductos = findViewById(R.id.failProductos);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchView.clearFocus();
        getData(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void getData(String q) {
        disguiseImagen();
        showProgresBar();
        disguiseUtilsNetwork();
        disguiseFailProductos();
        presenter.getData(q);
    }

    @Override
    public void showProduct(ArrayList<Productos> productos) {
        progressBarr.setVisibility(View.GONE);
        if (!productos.isEmpty()) {
            Intent showProductIntent = new Intent();
            showProductIntent.setClass(BuscarProductos.this, ProductosList.class);
            showProductIntent.putExtra("Productos", productos);
            startActivity(showProductIntent);
        }

    }

    @Override
    public void showUtilsNetwork() {
        notnetwork.setVisibility(View.VISIBLE);
    }

    @Override
    public void disguiseUtilsNetwork() {
        notnetwork.setVisibility(View.GONE);
    }

    @Override
    public void reload(View view) {
        getData(searchView.getQuery().toString());
    }

    @Override
    public void showImagen() {
        imagen.setVisibility(View.VISIBLE);
    }

    @Override
    public void disguiseImagen() {
        imagen.setVisibility(View.GONE);
    }

    @Override
    public void showProgresBar() {
        progressBarr.setVisibility(View.VISIBLE);
    }

    @Override
    public void disguiseProgresBar() {
        progressBarr.setVisibility(View.GONE);
    }

    @Override
    public void showFailProductos() {
        failProductos.setVisibility(View.VISIBLE);
    }

    @Override
    public void disguiseFailProductos() {
        failProductos.setVisibility(View.GONE);
    }

    private void OptionsMenu() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
        RelativeLayout contenedor = findViewById(R.id.principal);
        final LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        inflater.inflate(R.layout.nav_menu, contenedor, true);

        TextView categorias = findViewById(R.id.categorias);
        categorias.setOnClickListener(v -> {
            Log.i("ProductSearch", "Menu categorias");
            removeOptionsMenu();
            Intent i = new Intent(BuscarProductos.this, Categorias.class);
            i.putExtra("flag", false);
            startActivity(i);

        });
        TextView paises = findViewById(R.id.paises);
        paises.setOnClickListener(v -> {
            Log.i("ProductSearch", "Menu paises");
            removeOptionsMenu();
            Intent i = new Intent(BuscarProductos.this, Paises.class);
            startActivity(i);

        });

        RelativeLayout m = findViewById(R.id.menuOptions);
        m.setOnClickListener(v -> removeOptionsMenu());
    }

    private void removeOptionsMenu() {
        ViewGroup menus = findViewById(R.id.principal);
        RelativeLayout options = findViewById(R.id.menuOptions);
        menus.removeView(options);
    }
}