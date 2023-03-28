package day01;

public class Scope {

    public static void main(String[] args) {
        System.out.println("hello world");
        int n1 = 10;

        int n2 = 20;

        if (true) {
            int n3 = n1 + n2;
            System.out.println(n3);
        } // end if

        int userNumber = 1010;

    }
}
