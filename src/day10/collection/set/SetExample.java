package day10.collection.set;

import java.security.AlgorithmConstraints;
import java.util.*;

/**
 * - 집합 자료 구조
 * - 저장 순서를 보장하지 않음
 * - 인덱스, 키를 사용하지 않아서 개별 탐색이 불리함
 * - 저장 값의 중복을 허용하지 않음
 */
public class SetExample {
    public static void main(String[] args) {
        Set<String> foodSet = new HashSet<>();

        // 데이터 추가 add(E e)
        foodSet.add("김말이");
        foodSet.add("짜장면");
        foodSet.add("단무지");
        foodSet.add("김말이");
        foodSet.add("김밥");
        foodSet.add("단무지");

        for (String food : foodSet) {
            System.out.print("food = " + food + " <><><> ");
        }

        System.out.println();
        // remove(obj) : 삭제
        foodSet.remove("단무지");
        System.out.println("foodSet = " + foodSet);


        List<Integer> numbers = new ArrayList<>(
                Arrays.asList(1, 1, 1, 3, 3, 5, 6, 6, 7, 9, 9)
        );

        // 리스트를 SET 으로 변환
        Set<Integer> numberSet1 = new HashSet<>(numbers);
        Set<List<Integer>> numberSet2 = Set.of(numbers);
        Set<Integer> numbersSet3 = Set.copyOf(numbers);
        Set<Integer> numberSet4 = new HashSet<>();
        numberSet4.addAll(numbers);

        System.out.println("numberSet1 = " + numberSet1);
        System.out.println("=================================");
        System.out.println("numberSet2 = " + numberSet2);
        System.out.println("=================================");
        System.out.println("numbersSet3 = " + numbersSet3);
        System.out.println("=================================");
        System.out.println("numberSet4 = " + numberSet4);



    }
}
