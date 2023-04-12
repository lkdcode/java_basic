package day13.comparator;

import day13.Dish;
import day13.Menu;

import java.util.Comparator;
import java.util.stream.Collectors;

import static day13.Menu.menuList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Sorting {
    public static void main(String[] args) {
        // stream 의 정렬 sorted
        // 메뉴 목록 중 칼로리가 낮은 순으로 정렬
        menuList.stream()
                .sorted(comparing(Dish::getName))
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("\n\n\n");
        // 메뉴 목록 중 이름으로 내림차 정렬 (zyx순)
        menuList.stream()
                .sorted(comparing(Dish::getName).reversed())
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("\n\n\n");

        menuList.stream()
                .filter(o -> o.getCalories() > 300)
                .sorted(comparing(Dish::getCalories).reversed())
                .limit(3)
                .collect(toList())
                .forEach(System.out::println);

    }
}
