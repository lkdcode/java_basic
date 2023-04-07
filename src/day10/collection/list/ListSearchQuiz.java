package day10.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListSearchQuiz {
    private static final List<String> tvxq = new ArrayList<>(
            Arrays.asList("영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호")
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("* 변경 전 정보: " + tvxq);
            System.out.println("# 수정할 멤버의 이름을 입력하세요.");
            System.out.print(">> ");
            String inputName = sc.nextLine();

            int index = myIndexOf(inputName);

            if (index == -1) {
                System.out.println(inputName + "은(는) 없는 이름입니다.");
            } else {
                System.out.println(inputName + "의 별명을 변경합니다.");
                System.out.print(">> ");
                String changeName = sc.nextLine();

                System.out.println("변경 완료!!");

                tvxq.remove(index);
                tvxq.add(index, changeName);

                System.out.println("* 변경 후 정보: " + tvxq);
                return;
            }
        }
    }

    private static int myIndexOf(String inputName) {
        int index = 0;
        for (String name : tvxq) {
            if (name.equals(inputName)) return index;
            index++;
        }
        return -1;
    }
}
