package org.example.ordenarlista;

public class ComparadorNombre implements IComparador {
    @Override
    public int compare(Estudiante e1, Estudiante e2) {
        return e1.getNombre().compareTo(e2.getNombre());
    }

}
