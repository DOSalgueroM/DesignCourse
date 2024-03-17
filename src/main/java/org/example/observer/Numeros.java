package org.example.observer;



import java.util.ArrayList;
import java.util.List;

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
            if (n % 2 != 0) {
                numeros.add(n);
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