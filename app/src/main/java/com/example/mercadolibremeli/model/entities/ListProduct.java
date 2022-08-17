package com.example.mercadolibremeli.model.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class ListProduct implements Serializable {

    ArrayList<Product> results;

    public ArrayList<Product> getResults() {
        return results;
    }

}
