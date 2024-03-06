package org.example.venta;

import java.util.Scanner;

public class MainVenta {
    public static void main(String[] args) {
        Producto producto = new Producto("Coca Cola", 1.5, 500);
        Producto producto2 = new Producto("Pepsi", 1.5, 1000);
        Producto producto3 = new Producto("Fanta", 1.5, 60);
        Producto producto4 = new Producto("Papitas", 5.5, 50);
        Producto producto5 = new Producto("Salchipapa", 10.5, 20);
        /*VentaPorUnidad ventaPorUnidad = new VentaPorUnidad();
        VentaPorDocena ventaPorDocena = new VentaPorDocena();
        ventaPorUnidad.venta(producto);
        ventaPorDocena.venta(producto);*/
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        while (opcion!= 6) {
            printMenuVenta();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                   printMenuVenta2();
                    int opcion2 = scanner.nextInt();
                    if (opcion2 == 1) {
                        System.out.println("Cuantas unidades desea comprar?");
                        int cantidad = scanner.nextInt();
                        VentaPorUnidad ventaPorUnidad = new VentaPorUnidad();
                        ventaPorUnidad.venta(producto, cantidad);
                    } else if (opcion2 == 2) {
                        System.out.println("Cuantas docenas desea comprar?");
                        
                        VentaPorDocena ventaPorDocena = new VentaPorDocena();
                        ventaPorDocena.venta(producto, 1);
                    } else {
                        System.out.println("Opcion no valida");
                    }
                    break;
                case 2:
                    System.out.println("Cuantas unidades desea comprar?");
                    int cantidad2 = scanner.nextInt();
                    VentaPorUnidad ventaPorUnidad2 = new VentaPorUnidad();
                    ventaPorUnidad2.venta(producto2, cantidad2);
                    break;
                case 3:
                    System.out.println("Cuantas unidades desea comprar?");
                    int cantidad3 = scanner.nextInt();
                    VentaPorUnidad ventaPorUnidad3 = new VentaPorUnidad();
                    ventaPorUnidad3.venta(producto3, cantidad3);
                    break;
                case 4:
                    System.out.println("Cuantas unidades desea comprar?");
                    int cantidad4 = scanner.nextInt();
                    VentaPorUnidad ventaPorUnidad4 = new VentaPorUnidad();
                    ventaPorUnidad4.venta(producto4, cantidad4);
                    break;
                case 5:
                    System.out.println("Cuantas unidades desea comprar?");
                    int cantidad5 = scanner.nextInt();
                    VentaPorUnidad ventaPorUnidad5 = new VentaPorUnidad();
                    ventaPorUnidad5.venta(producto5, cantidad5);
                    break;
                case 6:
                    System.out.println("Gracias por su compra");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    public static void printMenuVenta(){
        System.out.println("Productos disponibles: ");
        System.out.println("1. Coca Cola");
        System.out.println("2. Pepsi");
        System.out.println("3. Fanta");
        System.out.println("4. Papitas");
        System.out.println("5. Salchipapa");
        System.out.println("6. Salir");
    }
    public static void printMenuVenta2(){
        System.out.println("Desea comprar por unidad o por docena?");
        System.out.println("1. Unidad");
        System.out.println("2. Docena");
    }
}
