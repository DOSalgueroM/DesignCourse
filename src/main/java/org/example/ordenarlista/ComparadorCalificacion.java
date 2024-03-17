package org.example.ordenarlista;

import java.util.ArrayList;
import java.util.List;

public class ComparadorCalificacion implements IComparador {
    @Override
    public int compare(Estudiante e1, Estudiante e2) {
        return (int) (e1.getCalificacion() - e2.getCalificacion());
    }

}
