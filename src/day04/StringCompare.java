package day04;

import java.util.Arrays;
import java.util.Scanner;

public class StringCompare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String myName = new String(new char[]{'홍', '길', '동'});

        String inputName = sc.nextLine();

        System.out.println("myName = " + myName);
        System.out.println("inputName = " + inputName);
        System.out.println("===============================");

        if (myName.equals(inputName)) {
            System.out.println("두 이름이 일치함!");
        } else {
            System.out.println("두 이름이 일치하지 않음!");
        }

        System.out.println(equals(new char[]{'홍', '규', '동'}, new char[]{'홍', '길', '동'}));
    }

    static boolean equals(char[] s1, char[] s2) {
        return Arrays.equals(s1, s2);
    }
}
