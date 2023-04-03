package day06.encap;

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("그랜져");

        myCar.setSpeed(500);
        System.out.println(myCar.getSpeed());

        myCar.setMode('A');
        System.out.println(myCar.getMode());

        myCar.pressButton();
    }
}
