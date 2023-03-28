package day02;

import java.util.Arrays;

public class ArrayBasic {

    public static void main(String[] args) {
        // 배열 객체 생성
        int[] arr = new int[5];

        System.out.println("arr = " + arr);

        arr[0] = 50;
        arr[1] = 77;
        arr[2] = arr[0] + 20;
        arr[3] = (int) 66.7;
        arr[4] = 100;

        // 배열의 길이 - 저장 데이터 개수
        // 자바의 배열 immutable(불변성)
        System.out.printf("배열의 길이: %d\n", arr.length);

        // 배열 반복문 처리

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d번 데이터 : %d\n", (i + 1), arr[i]);
        }

        System.out.println("============================");

        // for each 문

        // iter
        int i = 0;
        for (int number : arr) {
            System.out.println(number);
        }

        // 배열 내부데이터 문자열로 출력
        System.out.println(Arrays.toString(arr));

    }
}