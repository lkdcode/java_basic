package day12.lambda;

import java.util.ArrayList;
import java.util.List;

import static day12.lambda.Color.*;

// 사과를 여러 방법으로 필터링
public class FilterApple<T> {

    /**
     * @return : 녹색 사과들만 보여 있는 바구니
     * @solution - tye1 : 사과 바구니에서 녹색 사과만 필터링 해야 한다
     * @problem - 만약에 다른 색깔의 사과를 필터링 해야 한다면?
     * - 새로운 메서드가 필요하다
     * -
     * @param1 basket : 여러 사과가 모여 있는 바구니
     */
    public static List<Apple> filterGreenApples(List<Apple> basket) {
        // 녹색 사과만 담을 바구니
        List<Apple> greenApples = new ArrayList<>();

        for (Apple apple : basket) {
            if (apple.getColor() == GREEN) {
                greenApples.add(apple);
            }
        }

        return greenApples;
    }

    /**
     * @solution - try 2 : 색상을 파라미터화 한다.
     * @problem - 만약에 필터 기준이 색상이 아니라 무게라면?
     */
    public static List<Apple> filterApplesByColor(List<Apple> basket, Color color) {
        List<Apple> filteredApples = new ArrayList<>();

        for (Apple apple : basket) {
            if (apple.getColor() == color) {
                filteredApples.add(apple);
            }
        }

        return filteredApples;
    }

    /**
     * @solution - try 3 : 동작을 파라미터화 한다.
     * - 추상적 조건으로 필터링
     * @problem - 오렌지 바구니를 필터링해야 한다면?
     * - 전자 제품 바구니를 필터링해야 된다면?
     */
    public static List<Apple> filterApples(List<Apple> basket, ApplePredicate p) {
        List<Apple> filteredApples = new ArrayList<>();

        for (Apple apple : basket) {
            if (p.test(apple)) {
                filteredApples.add(apple);
            }
        }

        return filteredApples;
    }

    /**
     * @solution - try 4 : 제네릭 필터 메서드 생성
     */
    public static <T> List<T> filter(List<T> basket, GenericPredicate<T> p) {
        List<T> filterList = new ArrayList<>();

        for (T t : basket) {
            if (p.test(t)) {
                filterList.add(t);
            }
        }

        return filterList;
    }


}
