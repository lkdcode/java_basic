package day02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPushQuiz {

    private static String[] FOOD_LIST = new String[0];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("# 나의 장바구니 리스트");
            System.out.println("# 1. 먹고 싶은 매뉴 추가하기");
            System.out.println("# 2. 현재 담겨져 있는 목록 전체 조회");
            System.out.println("# 3. 마지막으로 추가한 삭제 및 조회");
            System.out.println("# 0. 종료하기");
            System.out.println();
            System.out.print("# 원하시는 매뉴 번호를 입력해주세요>> ");

            int menuNumber = scanner.nextInt();

            switch (menuNumber) {
                case 1:
                    System.out.println("# 먹고 싶은 음식을 입력하세요!!");
                    System.out.println("# 입력을 중지하려면 <그만>이라고 입력하세요.");
                    while (true) {
                        System.out.print(">> ");
                        String input = scanner.nextLine();

                        if (input.equals("그만")) {
                            break;
                        }
                        myPush(input);
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println("먹고 싶은 음식 리스트 : " + Arrays.toString(FOOD_LIST));
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("제거한 음식 매뉴 : " + myPop());
                    System.out.println("제거 후 먹고 싶은 음식 리스트 : " + Arrays.toString(FOOD_LIST));
                    System.out.println();
                    break;
                case 0:
                    System.out.println("# 종료 되었습니다.");
                    return;
                default:
                    System.out.println("잘 못 입력하였습니다.");
            }

        }

    }

    private static void myPush(String input) {
        String[] temp = new String[FOOD_LIST.length + 1];

        for (int i = 0; i < FOOD_LIST.length; i++) {
            temp[i] = FOOD_LIST[i];
        }

        temp[FOOD_LIST.length] = input;
        FOOD_LIST = temp;
    }

    private static String myPop() {
        String pop = FOOD_LIST[FOOD_LIST.length - 1];
        String[] temp = new String[FOOD_LIST.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = FOOD_LIST[i];
        }
        FOOD_LIST = temp;
        return pop;
    }

    private static StringBuilder viewList() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (String food : FOOD_LIST) {
            sb.append(food)
                    .append(", ");
        }

        sb.append(" ]");
        return sb;
    }

}
