package day13;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public static final List<Dish> menuList;

    static {
        menuList = List.of(
                new Dish("삼겹살", true, 30, Dish.Type.MEAT)
                , new Dish("맥주", false, 34630, Dish.Type.OTHER)
                , new Dish("우유", true, 330, Dish.Type.FISH)
                , new Dish("목살", false, 34630, Dish.Type.MEAT)
                , new Dish("사과", true, 31240, Dish.Type.FISH)
                , new Dish("바나나", true, 31240, Dish.Type.OTHER)
                , new Dish("식빵", false, 4630, Dish.Type.MEAT)
                , new Dish("오므라이스", false, 3036, Dish.Type.OTHER)
                , new Dish("업진살", false, 3036, Dish.Type.FISH)
                , new Dish("똠양꿍", false, 301, Dish.Type.OTHER)
                , new Dish("떡볶이", false, 23530, Dish.Type.FISH)
                , new Dish("짜장면", false, 32350, Dish.Type.FISH)
                , new Dish("호떡", false, 33460, Dish.Type.MEAT)
        );
    }

}
