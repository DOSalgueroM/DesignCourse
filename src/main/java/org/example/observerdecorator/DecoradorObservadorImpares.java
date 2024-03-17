package org.example.observerdecorator;

import java.util.ArrayList;
import java.util.List;

public class DecoradorObservadorImpares implements IObservador {
    IObservador observadorDecorado;

    public DecoradorObservadorImpares(IObservador obs) {
        observadorDecorado = obs;
    }
    @Override

    public void Actualizar(List<Integer> datos) {
        List<Integer> impares = new ArrayList<>();

        for (Integer n : datos) {
            if (n % 2 == 1) {
                impares.add(n);
            }
        }

        observadorDecorado.Actualizar(impares);
    }
}

