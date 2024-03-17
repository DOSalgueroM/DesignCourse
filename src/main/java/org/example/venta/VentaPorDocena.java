package org.example.venta;

import java.util.List;

public class VentaPorDocena implements ITipoVenta {
    @Override
    public void venta(List<Producto> productos ,int idproducto, int cantidad) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == idproducto) {
                if (productos.get(i).getStock() >= cantidad) {
                    int cantidadDocena = cantidad * 12;
                    productos.get(i).setStock(productos.get(i).getStock() - cantidadDocena);
                    for (int j = 1; j <= cantidad; j++) {
                        cantidadDocena = cantidadDocena - 2;
                    }
                    double pago = productos.get(i).getPrecio() * cantidadDocena;
                    System.out.println("El pago total  es: " + pago);
                } else {
                    System.out.println("No hay suficiente stock");
                }
            }
        }
        /*int cantidadDocena = cantidad * 12;

        producto.setStock(producto.getStock() - cantidad);
        for (int i = 1; i <= cantidad;i++)
        {
            cantidadDocena = cantidadDocena - 2;
        }
        double pago = producto.getPrecio() * cantidadDocena;
        System.out.println("El pago total  es: " + pago);*/

    }
}
