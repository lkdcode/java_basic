package day10.generic;

public class Basket<T> {

    private T fruit;

    public T getFruit() {
        return fruit;
    }

    public void setFruit(T fruit) {
        this.fruit = fruit;
    }
}
