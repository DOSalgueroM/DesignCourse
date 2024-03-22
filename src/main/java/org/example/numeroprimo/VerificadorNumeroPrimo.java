package org.example.numeroprimo;

public class VerificarNumeroPrimo {
    private int numero;
    public VerificarNumeroPrimo(int numero) {
        this.numero = numero;
    }
    public boolean esPrimo(){
        if (numero == 0 || numero == 1 || numero < 0){
            return false;
        }
        for (int i = 2; i < numero; i++){
            if (numero % i == 0){
                return false;
            }
        }
        return true;
    }
}
