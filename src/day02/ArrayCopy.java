package day02;

import java.util.Arrays;

public class ArrayCopy {

    public static void main(String[] args) {

        // 배열 복사 알고리즘
//        String[] pets = new String[]{
//                "멍멍이",
//                "야옹이",
//                "짹짹이",
//        };
        // 선언과 동시에 초기화한다면 new Type[] 생략 가능
        String[] pets = {"멍멍이", "야옹이", "짹짹이",};
//        String[] petsCopy = pets;
//        String[] petsCopy = pets;

        // 1. 원본과 동일한 사이즈의 배열을 하나 더 생성
        String[] petsCopy = new String[pets.length];

        // 2. 원본의 각 인덱스 값들을 사본에 인덱스로 일일히 복사
        for (int i = 0; i < pets.length; i++) {
            petsCopy[i] = pets[i];
        }


        System.out.println("원본주소 : " + pets);
        System.out.println("원본주소 : " + petsCopy);

        System.out.println("원본 배열 : " + Arrays.toString(pets));
        System.out.println("원본 배열 : " + Arrays.toString(petsCopy));
    }
}
