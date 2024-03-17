package org.example.observerdecorator;


public class Main {
    public static void main(String[] args) {
        Numeros n = new Numeros();
        ObservadorSumador sumador = new ObservadorSumador();
        n.Attach(sumador);
        ObservadorMayor mayor =new ObservadorMayor();
        n.Attach(mayor);

        ObservadorSumador sumador2 = new ObservadorSumador();
        DecoradorObservadorImpares decorador =  new DecoradorObservadorImpares(sumador2);
        n.Attach( decorador);

        ObservadorMayor mayor2 = new ObservadorMayor();
        DecoradorObservadorImpares decorador2 =  new DecoradorObservadorImpares(mayor2);
        n.Attach( decorador2);

        n.Adicionar(10);
        n.Adicionar(11);



        n.Eliminar(10);

    }
}
