package org.example.venta;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainVenta {
    public static void main(String[] args) {
        List<Producto> productos = getProductos();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            MenusVenta.printMenuVenta();
            elegirProducto(scanner, productos);
        }

    }

    private static void elegirProducto(Scanner scanner, List<Producto> productos) {
        int producto = scanner.nextInt();
        if (producto == 6){
            mostrarProductos(productos);
            return;
        }
        if (producto == 7){
            System.exit(0);
        }
        ITipoVenta tipoVenta = null;
        MenusVenta.printMenuVenta2();

        int opcionDos = scanner.nextInt();
        if (opcionDos == 1) {
            tipoVenta = new VentaPorUnidad();
            System.out.println("Ingrese la cantidad que requiere");
        } else if (opcionDos == 2) {
            tipoVenta = new VentaPorDocena();
            System.out.println("Ingrese las docenas que quiere:");

        } else {
            System.out.println("Opcion no valida");
        }
        int cantidad = scanner.nextInt();
        tipoVenta.venta(productos,producto, cantidad);
    }

    private static List<Producto> getProductos() {
        List<Producto> productos = Arrays.asList(
                new Producto("Coca Cola", 1.5, 500),
                new Producto("Pepsi", 1.5, 1000),
                new Producto("Fanta", 1.5, 60),
                new Producto("Papitas", 5.5, 50),
                new Producto("Salchipapa", 10.5, 20)
        );
        return productos;
    }

    public static void mostrarProductos(List<Producto> productos) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println(producto.getId() + " Nombre: " + producto.getNombre()+ " Precio: " + producto.getPrecio() + " Stock: " + producto.getStock());
        }

    }


}
