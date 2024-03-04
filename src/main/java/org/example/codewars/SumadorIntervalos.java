package org.example.codewars;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SumadorIntervalos {
    public static int sumIntervals(int[][] intervalos) {
        List<Intervalo> listaIntervalos = new ArrayList<>();

        for (int[] intervalo : intervalos) {
            listaIntervalos.add(ParserIntervalo.parsearIntervalo(intervalo));
        }

        listaIntervalos.sort(Comparator.comparingInt(Intervalo::getInicio));

        List<Intervalo> intervalosFusionados = new ArrayList<>();
        Intervalo intervaloActual = listaIntervalos.get(0);

        for (int i = 1; i < listaIntervalos.size(); i++) {
            Intervalo intervalo = listaIntervalos.get(i);

            if (VerificadorSolapamiento.haySolapamiento(intervaloActual, intervalo)) {
                intervaloActual = FucionadorIntervalos.funcionarIntervalos(intervaloActual, intervalo);
            } else {
                intervalosFusionados.add(intervaloActual);
                intervaloActual = intervalo;
            }
        }

        intervalosFusionados.add(intervaloActual);

        int suma = 0;
        for (Intervalo intervalo : intervalosFusionados) {
            suma += intervalo.duracion();
        }

        return suma;
    }
}
