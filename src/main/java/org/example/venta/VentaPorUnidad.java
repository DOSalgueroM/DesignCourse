package org.example.venta;

import java.util.List;

public class VentaPorUnidad implements ITipoVenta{
    double pago = 0;

    @Override
    public void venta(List<Producto> productos, int idProducto, int cantidad) {
        for (int i = 0; i < productos.size() ; i++) {
            if (productos.get(i).getId() == idProducto) {
                if (productos.get(i).getStock() >= cantidad) {
                    productos.get(i).setStock(productos.get(i).getStock() - cantidad);
                    pago = productos.get(i).getPrecio() * cantidad;
                    System.out.println("El pago total  es: " + pago);
                } else {
                    System.out.println("No hay suficiente stock");
                }
            }
        }
    }

}
