package org.example.codewars;

public class ParserIntervalo {
    public static Intervalo parsearIntervalo(int[] intervalo) {
        if (intervalo.length != 2) {
            throw new IllegalArgumentException("El arreglo de intervalo debe tener exactamente dos elementos.");
        }

        int inicio = intervalo[0];
        int fin = intervalo[1];

        if (inicio > fin) {
            throw new IllegalArgumentException("El inicio del intervalo debe ser menor o igual al fin del intervalo.");
        }

        return new Intervalo(inicio, fin);

    }
}
