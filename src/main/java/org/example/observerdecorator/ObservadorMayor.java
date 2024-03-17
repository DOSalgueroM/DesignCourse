package org.example.observerdecorator;


public class ObservadorMayor implements IObservador {
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
