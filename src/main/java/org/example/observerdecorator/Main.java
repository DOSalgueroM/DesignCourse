package org.example.observerdecorator;


public class Main {
    public static void main(String[] args) {
        int numero;
        Numeros n = new Numeros();
        ObservadorSumador sumador = new ObservadorSumador(n);
        n.Attach(sumador);
        ObservadorMayor mayor =new ObservadorMayor(n);
        n.Attach(mayor);
        ObservadorMenor menor = new ObservadorMenor(n);
        n.Attach(menor);

        DecoradorImpares decorador = new DecoradorImpares(n);
        numero = decorador.validarNumero(5);
        n.Adicionar(numero);
        numero =decorador.validarNumero(6);
        n.Adicionar(numero);
        numero =decorador.validarNumero(7);
        n.Adicionar(numero);

        //ICondicionNumeros decorador = new DecoradorImpares(n);

    }
}
