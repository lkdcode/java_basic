package day03;

import java.util.Arrays;

public class MethodQuiz {
    private static String[] foods = {"떡볶이", "치킨", "파스타"};

    public static void main(String[] args) {
        printFoods();

        push("라면");
        push("김치찌개");

        printFoods();

        // idx에 2가 리턴되어야 함.
        int idx = indexOf("파스타");
        System.out.println("idx = " + idx);
        // idx에 4가 리턴되어야 함.
        int idx2 = indexOf("김치찌개");
        System.out.println("idx2 = " + idx2);
        // idx에 -1이 리턴되어야 함.
        int idx3 = indexOf("짜장면");
        System.out.println("idx3 = " + idx3);

        remove("김치찌개"); // foods배열에서 김치찌개 제거
        remove("망고"); // 존재하지 않는 음식명입니다 출력.

        printFoods();


        boolean flag = include("파스타"); // 파스타 발견시 true 리턴
        System.out.println("flag = " + flag);
        boolean flag2 = include("양념치킨"); // 양념치킨 미발견시 false 리턴
        System.out.println("flag2 = " + flag2);

        insert(3, "파인애플"); // 3번 인덱스에 파인애플 삽입
        modify(2, "닭갈비");  // 2번 인덱스 데이터 닭갈비로 수정
//        clear();  // foods배열 모든 데이터 삭제

        printFoods();
    }

    private static void printFoods() {
        System.out.println(Arrays.toString(foods));
    }

    private static void push(String input) {
        String[] temp = new String[foods.length + 1];
        for (int i = 0; i < foods.length; i++) {
            temp[i] = foods[i];
        }
        temp[foods.length] = input;
        foods = temp;
    }

    private static void remove(String target) {
        int index = indexOf(target);
        if (index == -1) {
            System.out.println(target + "은(는) 존재하지 않습니다.");
            return;
        }

        String[] temp = new String[foods.length - 1];
        for (int i = 0, j = 0; i < temp.length; i++) {
            if (i == index) {
                continue;
            }
            temp[i] = foods[j++];
        }
        foods = temp;
        System.out.println(target + "을(를) 제거하였습니다.");
    }

    private static int indexOf(String target) {
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }


    private static boolean include(String target) {
        return indexOf(target) != -1;
    }

    private static void modify(int index, String target) {
        foods[index] = target;
    }

    private static void insert(int index, String target) {
        String[] temp = new String[foods.length + 1];

        for (int i = 0, j = 0; i < temp.length; i++) {
            if (i == index) {
                temp[i] = target;
                continue;
            }
            temp[i] = foods[j++];
        }
        foods = temp;
    }

    private static void clear() {
        foods = null;
    }

}