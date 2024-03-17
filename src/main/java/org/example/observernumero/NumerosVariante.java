package org.example.observernumero;

import java.util.ArrayList;
import java.util.List;

public class NumerosVariante {
    public static void main(String[] args) {

        Numeros n = new Numeros();
        ObservadorSumador sumador = new ObservadorSumador(n);
        n.Attach(sumador);
        ObservadorMayor mayor = new ObservadorMayor(n);
        n.Attach(mayor);
        ObservadorMenor menor = new ObservadorMenor(n);
        n.Attach(menor);

        n.Adicionar(10);
        n.Adicionar(20);
        n.Adicionar(60);
        n.Adicionar(28);
        n.Adicionar(69);
        n.Adicionar(5);
    }
}

interface IObservador {
    void Actualizar();
}

class Numeros {
    List<Integer> numeros;
    List<IObservador> observadores;

    public Numeros() {
        numeros = new ArrayList<>();
        observadores = new ArrayList<>();
    }

    public void Attach(IObservador observador) {
        observadores.add(observador);
    }

    public void Adicionar(int n) {
        if (!numeros.contains(n)) {
            numeros.add(n);
            if (n % 2 != 0) { // Verifica si el número es impar
                Notificar();
            }
        }
    }

    private void Notificar() {
        for (IObservador obs : observadores) {
            obs.Actualizar();
        }
    }

    public List<Integer> GetListaNumeros() {
        return numeros;
    }
}

class ObservadorSumador implements IObservador {
    private Numeros numeros;

    public ObservadorSumador(Numeros nums) {
        numeros = nums;
    }

    public void Actualizar() {
        int sumatoria = 0;
        for (int n : numeros.GetListaNumeros()) {
            sumatoria += n;
        }

        System.out.println("Sumatoria " + sumatoria);
    }
}

class ObservadorMayor implements IObservador {
    private Numeros numeros;

    public ObservadorMayor(Numeros nums) {
        numeros = nums;
    }

    public void Actualizar() {
        int mayor = Integer.MIN_VALUE;
        for (int n : numeros.GetListaNumeros()) {
            if (n > mayor) {
                mayor = n;
            }

        }

        System.out.println("El mayor es " + mayor);
    }
}

class ObservadorMenor implements IObservador {
    private Numeros numeros;

    public ObservadorMenor(Numeros nums) {
        numeros = nums;
    }

    public void Actualizar() {
        int menor = Integer.MAX_VALUE;
        for (int n : numeros.GetListaNumeros()) {
            if (n < menor) {
                menor = n;
            }

        }

        System.out.println("El menor es " + menor);
    }
}

