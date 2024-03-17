package org.example.observerdecorator;


import java.util.List;

class ObservadorMenor implements IObservador {

    public void Actualizar(List<Integer> datos) {
        int menor = Integer.MAX_VALUE;
        for (int n : datos) {
            if (n < menor) {
                menor = n;
            }

        }

        System.out.println("El menor es " + menor);
    }
}
