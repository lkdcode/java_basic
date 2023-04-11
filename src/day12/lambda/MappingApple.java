package day12.lambda;

// 사과 중에 원하는 필드들만 추출해서 새로운 리스트로 만들기

import java.util.ArrayList;
import java.util.List;

public class MappingApple<T, E> {

    // 사과의 색상만 추출
    public static List<Color> mappingAppleByColor(List<Apple> basket) {
        List<Color> colorList = new ArrayList<>();

        for (Apple apple : basket) {
            Color color = apple.getColor();

            colorList.add(color);
        }

        return colorList;
    }

    public static <T, E> List<E> map(List<T> basket, GenericFunction<T, E> mapper) {
        List<E> mappedList = new ArrayList<>();

        for (T t : basket) {
            E e = mapper.apply(t);
            mappedList.add(e);
        }

        return mappedList;
    }

}
