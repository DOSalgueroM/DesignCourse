package org.example.venta;

import java.util.List;

public class Producto {
    private static int ultimoId = 0;
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    //private List<Producto> producto;

    public Producto(String nombre, double precio, int stock) {
        this.id = ++ultimoId;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;

    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock)  {
        this.stock = stock;
    }

}
