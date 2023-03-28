package day01;

import java.util.Arrays;

public class DataType {
    public static void main(String[] args) {
        // 10진수 1000 : 0011 1110 1000
        // 8bit == 1byte
        // 1024byte == 1kb
        int a = Integer.MAX_VALUE; // 2147483647
        long b = Long.MAX_VALUE; // 9223372036854775807

        System.out.println(a);
        System.out.println(b);

        byte n = 127;
        System.out.println(n);

        long money = 21474836470L; // 8바이트로 할당

//        100; // 메모리에 저장 (리터럴 4바이트 할당)
        int number; // 4바이트 공간 할당. 이름을 a 부여
        number = 100; // 미리 저장된 100을 a에 복사

        // 실수 리터럴은 기본으로 8바이트 할당
        // float 4바이트 : 다운 캐스팅이 필요
        float f1 = Float.MAX_VALUE;
        float f2 = 1.23456789F;
        System.out.println(f1);
        System.out.println(f2);

        System.out.println("f2 = " + f2);

        double d1 = 1.23445333848753784142879; // 8바이트.
        // 더 늘리려면 객체를 사용해야한다
        System.out.println("d1 = " + d1);

        Double d2 = 1.23445333848753784142879;
        System.out.println("d2 = " + d2);

        // 논리 타입

        boolean b1 = true;
        boolean b2 = false;

        System.out.println("b2 = " + b2);
        System.out.println("b1 = " + b1);

        Boolean test = Boolean.TRUE;

        // 문자 타입 : 한글자
        char c1 = 'A';
        System.out.println((char) (c1 + 1));

        char c2 = 44032;
        System.out.println("c2 = " + (int) c2);

        // 기본 타입 x 객체다.
        // char 의 배열형태다
        String s = "hello";

        System.out.println("s = " + s);
    }
}