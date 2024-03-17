package org.example.ordenarlista;

import java.util.List;

public interface IComparadorFactory {

    IComparador crearComparador(String tipo);
}
