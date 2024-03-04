package org.example.consoleprogram;

class Item<T> {
    private T data;

    public Item(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
