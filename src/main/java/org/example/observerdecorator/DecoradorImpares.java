package org.example.observerdecorator;

import java.util.ArrayList;
import java.util.List;

public class DecoradorImpares extends ObservadorDecorador{
    private int aux = 0;

    public DecoradorImpares(ICondicionNumeros condicionNumeros) {
        super(condicionNumeros);
    }

    @Override
    public int validarNumero(int numero) {
        if (numero % 2 == 0) {
            System.out.println("El número " + numero + " es par, no se añadirá a la lista");
            return 0;

        }
        return numero;
    }
}
