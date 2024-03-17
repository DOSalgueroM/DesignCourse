package org.example.observer;


public class Main {
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
