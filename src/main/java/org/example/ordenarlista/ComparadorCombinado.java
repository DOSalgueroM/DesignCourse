package org.example.ordenarlista;

public class ComparadorCombinado implements IComparador{
    private final IComparador comparador1;
    private final IComparador comparador2;
    public ComparadorCombinado() {
        this.comparador1 = new ComparadorNombre();
        this.comparador2 = new ComparadorEdad();
    }

    public ComparadorCombinado(IComparador comparador1, IComparador comparador2) {
        this.comparador1 = comparador1;
        this.comparador2 = comparador2;
    }

    @Override
    public int compare(Estudiante estudiante1, Estudiante estudiante2) {
        int comparacion1 = comparador1.compare(estudiante1, estudiante2);
        if (comparacion1 == 0) {
            return comparador2.compare(estudiante1, estudiante2);
        } else {
            return comparacion1;
        }
    }

}
