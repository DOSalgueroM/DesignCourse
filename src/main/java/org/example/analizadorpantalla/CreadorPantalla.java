package org.example.analizadorpantalla;



public class CreadorPantalla {
    char[][] pantalla = new char[20][50];

    public char[][] crearPantalla(){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 50; j++) {
                pantalla[i][j] = '.';
            }
        }
        return pantalla;
    }



}
