package day02;

import java.util.Locale;
import java.util.Scanner;

public class SwitchExample {
    // 자바 상수
    public static final String SPRING = "봄";

    public static void main(String[] args) {

        System.out.println("### 여행지 추천 ###");
        System.out.println("[ 원하는 계절을 입력하세요. ]");
        System.out.println(">> "); // 봄, 여름, 가을, 겨울

        Scanner sc = new Scanner(System.in);


        String season = sc.nextLine();

        switch (season) {
            case SPRING:
                System.out.println("봄에는 여의도를 가세요!");
                break;
            case "여름":
                System.out.println("여름에는 홍천을 가세요!");
                break;
            case "가을":
                System.out.println("가을에는 춘천을 가세요!");
                break;
            case "겨울":
                System.out.println("겨울에는 스키장을 가세요!");
                break;
            default: // else
                System.out.println("계절을 잘 입력하세요 ^0^");
        }

        System.out.println("====================");
        System.out.print("정말로 종료합니까? [y/n >>");

        String answer = sc.nextLine();

        switch (String.valueOf(answer.toLowerCase().charAt(0))) {
            case "y":
                System.out.println("종료합니다.");
                break;
            case "n":
                System.out.println("취소합니다.");
                break;
        }
    }
}