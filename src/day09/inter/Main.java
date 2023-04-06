package day09.inter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BullDog bullDog = new BullDog();

        bullDog.hunt();
        bullDog.violent();
        bullDog.eat();

        Duck duck = new Duck();
        duck.eat();
        // 인터페이스는 다형성을 구현하는 역할
        Pet[] pets = {
                new BullDog(),
                new Duck(),
                new Rabbit(),
        };

        for (Pet pet : pets) {
            pet.eat();
        }

    }
}