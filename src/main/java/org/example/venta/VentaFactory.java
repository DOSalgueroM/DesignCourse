package org.example.venta;

public class VentaFactory{

    public static ITipoVenta getVenta(int tipoVenta){
        switch(tipoVenta){
            case 1:
                return new VentaPorUnidad();
            case 2:
                return new VentaPorDocena();
            default:
                return null;
        }
    }
}
