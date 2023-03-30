package day04;

public class FieldAndLocal {

    int a; // 필드

    void mm(int b/* b: 매개변수 */) {
        int c = 123; // c: 지역변수

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

}