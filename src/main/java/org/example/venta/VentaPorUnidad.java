package org.example.venta;

public class VentaPorUnidad implements ITipoVenta{
    double pago = 0;

    @Override
    public void venta(Producto producto, int cantidad) {
        producto.setStock(producto.getStock() - cantidad);

        pago = producto.getPrecio() * cantidad;
        System.out.println("El pago total  es: " + pago);
    }
}
