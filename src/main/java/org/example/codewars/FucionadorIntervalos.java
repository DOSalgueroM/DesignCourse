package org.example.codewars;

public class FucionadorIntervalos {
    public static Intervalo funcionarIntervalos(Intervalo intervalo1, Intervalo intervalo2) {
        int inicio = Math.min(intervalo1.inicio, intervalo2.inicio);
        int fin = Math.max(intervalo1.fin, intervalo2.fin);
        return new Intervalo(inicio, fin);
    }
}
