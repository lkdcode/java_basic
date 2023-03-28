package day02;

import java.util.Arrays;

public class ArrayPop {

    public static int pop() {
        if (arr.length > 0) {
            int result = arr[arr.length - 1];

            // 1. 원본 배열보다 1개 사이즈 작은 새 배열 생성
            int[] temp = new int[arr.length - 1];

            // 2. 맨 마지막 데이터만 빼고 모두 새 배열에 복사
            for (int i = 0; i < temp.length; i++) {
                temp[i] = arr[i];
            }
            // 3. 주소값 이전
            arr = temp;
            temp = null;

            return result;
        }

        return -1;
    }

    static int[] arr = {10, 20, 30, 40, 50};

    public static void main(String[] args) {
        // 배열의 맨 끝 데이터 삭제
        System.out.println(pop());
        System.out.println(Arrays.toString(arr));

    }
}
