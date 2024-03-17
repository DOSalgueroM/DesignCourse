package org.example.venta;

import java.util.List;

public interface ITipoVenta {
    //void venta(Producto producto, int cantidad);
    void venta(List<Producto> productos,int idProducto, int cantidad);
}
