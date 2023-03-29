package day03;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int korScore = 10;
        int mathScore = 20;
        int engScore = 30;

        int[] kimScores = {korScore, mathScore, engScore};
        int[] parkScores = {100, 34, 99};
        int[] hongScores = {10, 100, 11};

        int[][] classScores = {kimScores, parkScores, hongScores};

        System.out.println(Arrays.deepToString(classScores));

        int[][][] test = {classScores};
        System.out.println(Arrays.deepToString(test));


        // 2차원 배열의 값 초기화
        int[][] arr2d = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90},
                {100, 200, 300}
        };

        System.out.println("=====================");
        System.out.println(arr2d[1][2]);

        int[] arr3 = arr2d[2];
        for (int[] i : arr2d) {
            for (int number : i) {
                System.out.printf("%4d ", number);
            }
            System.out.println();
        }

        // 배열의 기본값
        // 정수 배열은 0이 기본값, 실수는 0.0이 기본값
        // boolean 배열은 false 기본값,
        // char 배열은 공백 기본값,
        // 객체 배열은 null
        // 
        int[] numbers = new int[5];

        // 5행 4열
        int[][] array2d = new int[5][4];

        // 2차원 배열의 수정
        // array2d
        array2d[1][3] = 99;
        array2d[2][1] = 55;
        array2d[3] = new int[]{9, 8, 7, 6};

        System.out.println("===========================");

        for (int[] ints : array2d) {
            for (int anInt : ints) {
                System.out.printf("%5d ", anInt);
            }
            System.out.println();
        }

        // 3차원 배열
        int[][][] arr3d = {
                {
                        {10, 20},
                        {30, 40},
                        {50, 60},
                },
                {
                        {70, 80},
                        {90, 100},
                        {200, 300},
                },
                {
                        {400, 500},
                        {600, 700},
                        {800, 900},
                }
        };
        System.out.println(Arrays.deepToString(arr3d));
    }
}
