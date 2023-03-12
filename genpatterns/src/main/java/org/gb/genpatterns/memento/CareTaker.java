package org.gb.genpatterns.memento;

public class CareTaker implements Mementoble{

    public Memento getMemento() {
        return memento;
    }

    private Memento memento;

    public CareTaker(Memento memento) {
        this.memento = memento;
    }

}
