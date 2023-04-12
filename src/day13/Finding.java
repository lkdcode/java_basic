package day13;

import java.util.Comparator;
import java.util.Optional;

import static day13.Menu.menuList;

public class Finding {

    public static void main(String[] args) {


        // 메뉴 목록에서 채식주의자가 먹을 수 있는 요리가
        // 하나라도 존재하는가?

        boolean flag1 = menuList.stream()
                .anyMatch(Dish::isVegeterian);

        System.out.println("flag1 = " + flag1);

        boolean flag2 = menuList.stream()
                .anyMatch(o -> o.getCalories() < 100);

        // 메뉴 목록의 모든 요리가 1000칼로리 미만인가?
        boolean flag3 = menuList.stream()
                .allMatch(o -> o.getCalories() < 100);
        System.out.println("flag3 = " + flag3);

        // nonMatch : allMatch 의 반대 연산

        Dish min = menuList.stream()
                .min(Comparator.comparing(Dish::getCalories))
                .get();

        System.out.println(min);


    }
}
