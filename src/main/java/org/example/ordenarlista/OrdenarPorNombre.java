package org.example.ordenarlista;

public class OrdenarPorNombre implements IOrdenarDatosEstudiante{
    private Estudiante[] estudiantes;
    @Override
    public void ordenar(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
        for (int i = 0; i < estudiantes.length - 1; i++) {
            for (int j = 0; j < estudiantes.length - 1; j++) {
                if (estudiantes[j].getNombre().compareTo(estudiantes[j + 1].getNombre()) > 0) {
                    Estudiante temp = estudiantes[j];
                    estudiantes[j] = estudiantes[j + 1];
                    estudiantes[j + 1] = temp;
                }
            }
        }
    }
    @Override
    public void print() {
        System.out.println("Lista por nombre");
        System.out.println("Estudiante    Edad    Calificacion");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.getNombre() + " " + estudiante.getEdad() + " " + estudiante.getCalificacion());
        }
    }
}
