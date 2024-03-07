package org.example.ordenarlista;

import java.util.ArrayList;
import java.util.List;

public class OrdenarPorCalificacion implements IOrdenarDatosEstudiante{
    private List<Estudiante> estudiantes = new ArrayList<Estudiante>();
    @Override
    public void ordenar(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
        for (int i = 0; i < estudiantes.size() - 1; i++) {
            for (int j = 0; j < estudiantes.size() - 1; j++) {
                if (estudiantes.get(j).getCalificacion() > estudiantes.get(j + 1).getCalificacion()) {
                    Estudiante temp = estudiantes.get(j);
                    estudiantes.set(j, estudiantes.get(j + 1));
                    estudiantes.set(j + 1, temp);
                }
            }
        }

    }
    @Override
    public void print() {
        System.out.println("Lista por calificacion");
        System.out.println("Estudiante    Edad    Calificacion");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.getNombre() + "           " + estudiante.getEdad() + "       " + estudiante.getCalificacion());
        }
    }
}
