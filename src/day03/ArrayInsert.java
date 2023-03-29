package day03;

import java.util.Arrays;

public class ArrayInsert {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        // 20이랑 30 사이에 넣고 싶음
        int targetIndex = 2;
        int newData = 25;

        // 1. 배열의 사이즈를 먼저 1 늘려놓음
        // 2. 원본 배열을 다 복사해놓음
        // 3. 맨 뒤부터 타겟 인덱스까지 한 칸씩 뒤로 민다
        // 4. 타겟 인덱스 자리에 새 데이터를 넣는다.
        // 5. 주소를 바꾼다.
        int[] changeArr = new int[arr.length + 1];

        for (int i = 0, j = 0; i < changeArr.length; i++) {
            if (i == targetIndex) {
                changeArr[i] = newData;
                continue;
            }
            changeArr[i] = arr[j++];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(changeArr));
    }
}
