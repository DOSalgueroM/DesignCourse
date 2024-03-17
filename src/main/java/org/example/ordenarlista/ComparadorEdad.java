package org.example.ordenarlista;

public class ComparadorEdad implements IComparador {
    @Override
    public int compare(Estudiante e1, Estudiante e2) {
        return e1.getEdad() - e2.getEdad();
    }


}
