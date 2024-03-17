package org.example.sumaintervalo;

public class VerificadorSolapamiento {
    public static boolean haySolapamiento(Intervalo intervalo1, Intervalo intervalo2) {
        return intervalo1.inicio < intervalo2.fin && intervalo2.inicio < intervalo1.fin;
    }
}
