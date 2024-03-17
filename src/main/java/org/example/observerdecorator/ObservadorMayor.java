package org.example.observerdecorator;


import java.util.List;

public class ObservadorMayor implements IObservador {

    public void Actualizar(List<Integer> datos) {
        int mayor = Integer.MIN_VALUE;
        for (int n : datos) {
            if (n > mayor) {
                mayor = n;
            }

        }

        System.out.println("El mayor es " + mayor);
    }
}
