package day13;

import java.util.List;

import static day13.Menu.menuList;
import static java.util.stream.Collectors.toList;

public class Filtering {
    public static void main(String[] args) {

        // stream 의 filter
        // 필터 조건에 맞는 데이터들을 필터링

        // 메뉴 목록 중에 채식주의자가 먹을 수 있는 요리를 알려주세요
        List<Dish> collect = menuList.stream()
                .filter(Dish::isVegeterian)
                .collect(toList());

        System.out.println("==================================");
        collect.forEach(System.out::println);

        // 메뉴 목록 중에서 600칼로리 미만인 요리 필터링

        System.out.println("==================================");

        List<Dish> filteredDish = menuList.stream()
                .filter(o -> o.getCalories() >= 600)
                .filter(o -> o.getType() == Dish.Type.MEAT)
                .collect(toList());

        filteredDish.forEach(System.out::println);

        String greeting = "hello world!";
        char c = greeting.toUpperCase()
                .substring(0, 5)
                .charAt(3);

        System.out.println("===================================================");

// 매뉴 목록에서 요리의 이름이 4글자인 요리들만 필터링해서 출력
        menuList.stream()
                .filter(o -> o.getName().length() == 2)
                .forEach(System.out::println);

        System.out.println("===================================================");

        // 원하는 개수만 필터리앟기
        // 칼로리가 300칼로리보다 큰 요리 중 앞에서 3개만 필터링
        menuList.stream()
                .filter(o -> o.getCalories() >= 300)
                .limit(3)
                .forEach(System.out::println);

        // 필터된 값 중 처음 2개 스킵하고 3개만.
        menuList.stream()
                .filter(o -> o.getCalories() >= 300)
                .skip(2) // 맨 앞 2개 제외
                .limit(3)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("=============== 처음 등장하는 2개의 고기 요리 ===============");
        System.out.println();
        // 메뉴 목록에서 처음 등장하는 2개의 고기 요리를 필터링
        // 리스트에 반환
        List<Dish> meatFilteredList = menuList.stream()
                .filter(o -> o.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList());

        meatFilteredList.forEach(System.out::println);

        // 중복 제거
        System.out.println();
        System.out.println("=============== 중복 제거 ===============");
        System.out.println();

        List<Integer> numbers = List.of(1, 2, 3, 1, 2, 31, 3, 42, 3, 2, 346, 5, 346, 2356, 246, 37, 73523, 12, 1, 1, 3, 1, 324, 34, 23, 5, 21, 13, 132, 12, 1, 24, 12, 31, 3, 13, 12, 41, 42, 35, 235, 12, 3, 2, 25);

        // 리스트에서 짝수만 걸러낸 뒤 중복 제거하기
        List<Integer> distinctedNumbers = numbers.stream()
                .filter(o -> o % 2 == 0)
                .distinct() // 중복 제거
                .collect(toList());

        System.out.println(distinctedNumbers);

    }
}
