package day07.util;

import java.util.Scanner;

public class Utility {
    private static Scanner sc = new Scanner(System.in);

    private Utility() {
    }

    // 구분선을 출력하는 기능
    public static void makeLine() {
        System.out.println("================================");
    }

    public static String input(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

}
