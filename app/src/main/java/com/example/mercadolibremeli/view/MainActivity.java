package com.example.mercadolibremeli.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mercadolibremeli.R;
import com.example.mercadolibremeli.interfaces.product.InterfacePresenter;
import com.example.mercadolibremeli.interfaces.product.InterfaceView;
import com.example.mercadolibremeli.model.entities.Product;
import com.example.mercadolibremeli.presenter.Productpresenter;
import com.example.mercadolibremeli.view.category.Categorias;
import com.example.mercadolibremeli.view.paises.Paises;
import com.example.mercadolibremeli.view.product.ProductList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements InterfaceView, SearchView.OnQueryTextListener {

    private InterfacePresenter presenter = new Productpresenter(this, MainActivity.this);
    private androidx.appcompat.widget.SearchView searchView;
    private ImageView menu;
    private RecyclerView recyclerViewSearchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initV();
        menu.setOnClickListener(v -> OptionsMenu());
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
            Intent i = new Intent(MainActivity.this, Categorias.class);
            i.putExtra("flag", false);
            startActivity(i);

        });
        TextView paises = findViewById(R.id.paises);
        paises.setOnClickListener(v -> {
            Log.i("ProductSearch", "Menu paises");
            removeOptionsMenu();
            Intent i = new Intent(MainActivity.this, Paises.class);
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
        menu=findViewById(R.id.menu);
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
        presenter.getData(q);
    }

    @Override
    public void showProduct(ArrayList<Product> productos) {
        if(!productos.isEmpty()){
            Intent showProductIntent = new Intent();
            showProductIntent.setClass(MainActivity.this, ProductList.class);
            showProductIntent.putExtra("Productos",productos);
            startActivity(showProductIntent);
        }

    }
}