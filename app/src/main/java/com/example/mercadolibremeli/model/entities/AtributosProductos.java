package com.example.mercadolibremeli.model.entities;

import java.io.Serializable;

public class AtributosProductos implements Serializable {
    private String name;
    private String value_name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue_name() {
        return value_name;
    }

    public void setValue_name(String value_name) {
        this.value_name = value_name;
    }
}