package com.example.mercadolibremeli.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
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

import com.example.mercadolibremeli.R;
import com.example.mercadolibremeli.interfaces.productos.InterfacePresenter;
import com.example.mercadolibremeli.interfaces.productos.InterfaceView;
import com.example.mercadolibremeli.model.entities.Productos;
import com.example.mercadolibremeli.presenter.productos.Productospresenter;
import com.example.mercadolibremeli.view.categorias.Categorias;
import com.example.mercadolibremeli.view.paises.Paises;
import com.example.mercadolibremeli.view.productos.ProductosList;

import java.util.ArrayList;

public class BuscarProductos extends AppCompatActivity implements InterfaceView, SearchView.OnQueryTextListener {

    private InterfacePresenter presenter = new Productospresenter(this, BuscarProductos.this);
    private androidx.appcompat.widget.SearchView searchView;
    private ImageView menu;
    private ProgressBar progressBarr;
    private LinearLayout notnetwork;
    private ImageView imagen;
    private LinearLayout failProductos;
    private TextView reintento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initV();
        menu.setOnClickListener(v -> OptionsMenu());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showImagen();
        disguiseFailProductos();
        disguiseUtilsNetwork();
    }

    private void OptionsMenu() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow( searchView.getWindowToken(), 0);
        RelativeLayout contenedor = (RelativeLayout) findViewById(R.id.principal);
        final LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        inflater.inflate(R.layout.nav_menu,contenedor,true);

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

    private void removeOptionsMenu(){
        ViewGroup menu = findViewById(R.id.principal);
        RelativeLayout options = findViewById(R.id.menuOptions);
        menu.removeView(options);
    }

    @Override
    public void initV() {

        failProductos = findViewById(R.id.failProductos);
        imagen = findViewById(R.id.imagen);
        reintento = findViewById(R.id.reintento);
        notnetwork = findViewById(R.id.notnetwork);
        progressBarr = findViewById(R.id.progressbar_loading);
        menu = findViewById(R.id.menu);
        searchView = findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(this);
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
        if(!productos.isEmpty()){
            Intent showProductIntent = new Intent();
            showProductIntent.setClass(BuscarProductos.this, ProductosList.class);
            showProductIntent.putExtra("Productos",productos);
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
}