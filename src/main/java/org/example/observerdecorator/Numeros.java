package org.example.observerdecorator;



import java.util.ArrayList;
import java.util.List;

public class Numeros
{
    List<Integer> numeros;
    List<IObservador> observadores;
    public Numeros()
    {
        numeros = new ArrayList<>();
        observadores = new ArrayList<>();
    }

    public void Attach(IObservador observador)
    {
        observadores.add(observador);
    }

    public void Adicionar(int n)
    {
        if (!numeros.contains(n)){
            numeros.add(n);
            Notificar();
        }
    }

    public void Eliminar(int n)
    {
        if (numeros.contains(n)){
            numeros.remove(numeros.indexOf( n));
            Notificar();
        }
    }

    private void Notificar()
    {
        for(IObservador obs : observadores){
            obs.Actualizar(numeros);
        }
    }

    public List<Integer> GetListaNumeros(){
        return numeros;
    }
}