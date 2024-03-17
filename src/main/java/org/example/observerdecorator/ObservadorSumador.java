package org.example.observerdecorator;


import java.util.List;

class ObservadorSumador implements IObservador {

    public void Actualizar(List<Integer> datos) {
        int sumatoria = 0;
        for (int n : datos) {
            sumatoria += n;
        }

        System.out.println("Sumatoria " + sumatoria);
    }
}
