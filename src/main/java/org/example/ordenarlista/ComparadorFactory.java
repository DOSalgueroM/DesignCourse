package org.example.ordenarlista;

public class ComparadorFactory implements IComparadorFactory{

    private static ComparadorFactory instance;

    private ComparadorFactory() {}

    public static ComparadorFactory getInstance() {
        if (instance == null) {
            instance = new ComparadorFactory();
        }
        return instance;
    }


    private IComparador crearComparadorSimple(String tipo) {
        switch (tipo) {
            case "nombre":
                return new ComparadorNombre();
            case "edad":
                return new ComparadorEdad();
            case "calificacion":
                return new ComparadorCalificacion();
            case "combinado":
                return new ComparadorCombinado();
            default:
                throw new IllegalArgumentException("Tipo de comparador no válido: " + tipo);
        }
    }
    @Override
    public IComparador crearComparador(String campos) {
        IComparador comparador = null;
        for (String campo : campos.split(" ")) {
            if (comparador == null) {
                comparador = crearComparadorSimple(campo);
            } else {
                comparador = new ComparadorCombinado(comparador, crearComparador(campo));
            }
        }
        return comparador;
    }
}
