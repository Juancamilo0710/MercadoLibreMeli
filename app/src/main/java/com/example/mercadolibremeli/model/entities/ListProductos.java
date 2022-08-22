package com.example.mercadolibremeli.model.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class ListProductos implements Serializable {

    ArrayList<Productos> results;

    public ArrayList<Productos> getResults() {
        return results;
    }

}
