package org.example.observerdecorator;



import java.util.ArrayList;
import java.util.List;

public class Numeros implements ICondicionNumeros{
    List<Integer> numeros;
    List<IObservador> observadores;

    ICondicionNumeros condicion;

    public Numeros() {
        numeros = new ArrayList<>();
        observadores = new ArrayList<>();
        //condicion = new DecoradorImpares();
    }

    public void Attach(IObservador observador) {
        observadores.add(observador);
    }


    public void Adicionar(int n)
    {

        if (!numeros.contains(n)){
            if(n != 0) {
                numeros.add(n);
            }
            Notificar();
        }
    }

    private void Notificar() {
        for (IObservador obs : observadores) {
            obs.Actualizar();
        }
    }

    public List<Integer> GetListaNumeros() {
        return numeros;
    }

    @Override
    public int validarNumero(int numero) {
        return 0;
    }
}