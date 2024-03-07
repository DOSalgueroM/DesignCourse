package org.example.venta;

import java.util.Scanner;

public class MainVenta {
    public static void main(String[] args) {
        Producto producto = new Producto("Coca Cola", 1.5, 500);
        Producto producto2 = new Producto("Pepsi", 1.5, 1000);
        Producto producto3 = new Producto("Fanta", 1.5, 60);
        Producto producto4 = new Producto("Papitas", 5.5, 50);
        Producto producto5 = new Producto("Salchipapa", 10.5, 20);

        Scanner scanner = new Scanner(System.in);
        MenusVenta.printMenuVenta();

        int opcion = 0;


    }


}
