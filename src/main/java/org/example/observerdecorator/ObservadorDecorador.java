package org.example.observerdecorator;

public abstract class ObservadorDecorador implements ICondicionNumeros {
    protected ICondicionNumeros observador;

    public ObservadorDecorador(ICondicionNumeros observador) {
        this.observador = observador;
    }

    /*@Override
    public void Adicionar(int numero) {
        observador.Actualizar();
    }*/


}

