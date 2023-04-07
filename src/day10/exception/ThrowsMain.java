package day10.exception;

public class ThrowsMain {
    public static void main(String[] args) {

        ThrowsExample te = new ThrowsExample();

        int number1 = te.inputNumber();
        int number2 = te.convert("3e");

        System.out.println("number1 = " + number1);
        System.out.println("number2 = " + number2);
    }
}
