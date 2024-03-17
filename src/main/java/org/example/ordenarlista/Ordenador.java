package org.example.ordenarlista;

import java.util.List;

public class Ordenador {
    IComparador comparer;

    public Ordenador(IComparador comparer) {
        this.comparer = comparer;
    }
    //@Override

    public void sort(List<Estudiante> estudiantes) {


        for (int i = 0; i < estudiantes.size() - 1; i++) {
            for (int j = 0; j < estudiantes.size() - i - 1; j++) {
                if (comparer.compare(estudiantes.get(j), estudiantes.get(j + 1)) > 0) {
                    Estudiante temp = estudiantes.get(j);
                    estudiantes.set(j, estudiantes.get(j + 1));
                    estudiantes.set(j + 1, temp);
                }
            }
        }



    }

    /*@Override
    public IComparador sort(String tipo) {
        return null;
    }*/
}
