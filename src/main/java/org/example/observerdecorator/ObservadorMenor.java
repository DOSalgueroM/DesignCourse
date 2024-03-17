package org.example.observerdecorator;


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
