package org.example.observerdecorator;


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
