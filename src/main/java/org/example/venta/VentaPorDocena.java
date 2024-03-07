package org.example.venta;

public class VentaPorDocena implements ITipoVenta {
    @Override
    public void venta(Producto producto, int cantidad) {
        int cantidadDocena = cantidad * 12;

        producto.setStock(producto.getStock() - cantidad);
        for (int i = 1; i <= cantidad;i++)
        {
            cantidadDocena = cantidadDocena - 2;
        }
        double pago = producto.getPrecio() * cantidadDocena;
        System.out.println("El pago total  es: " + pago);

    }
}
