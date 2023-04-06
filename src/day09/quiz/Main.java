package day09.quiz;

public class Main {
    public static void main(String[] args) {

        SmartPhone[] smartPhones = {
                new Galaxy(),
                new IPhone(),
        };

        for (SmartPhone smartPhone : smartPhones) {
            String message = smartPhone.information();
            System.out.println(message);
        }


    }
}
