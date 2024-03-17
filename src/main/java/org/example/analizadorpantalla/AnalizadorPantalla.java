package org.example.analizadorpantalla;

class AnalizadorPantalla {
    private char[][] pantalla;

    public AnalizadorPantalla(char[][] pantalla) {
        this.pantalla = pantalla;
    }

    public int contarCuadros() {
        int numCuadros = 0;

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 50; j++) {
                if (pantalla[i][j] == '┌') {
                    int tamanoCuadro = calcularTamanoCuadro(i, j);
                    if (tamanoCuadro >= 2) {
                        numCuadros++;
                    }
                }
            }
        }

        return numCuadros;
    }

    public StringBuilder obtenerCoordenadasCuadros() {
        StringBuilder coordenadasCuadros = new StringBuilder();

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 50; j++) {
                if (pantalla[i][j] == '┌') {
                    int tamanoCuadro = calcularTamanoCuadro(i, j);
                    if (tamanoCuadro >= 2) {
                        coordenadasCuadros.append(j).append(' ').append(i).append(' ').append(tamanoCuadro).append('\n');
                    }
                }
            }
        }

        return coordenadasCuadros;
    }

    private int calcularTamanoCuadro(int startY, int startX) {
        int tamanoCuadro = 2;
        int y = startY + 1;
        int x = startX + 1;

        while (y < 20 && x < 50 && pantalla[y][x] == '│' && pantalla[y][startX] == '└' && pantalla[startY][x] == '┐') {
            tamanoCuadro++;
            y++;
            x++;
        }

        return tamanoCuadro;
    }
}
