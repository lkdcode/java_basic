package day13;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static day13.Menu.menuList;
import static java.util.stream.Collectors.toList;

public class Mapping {
    public static void main(String[] args) {

        // stream의 map : 리스트에서 원하는 정보만 추출

        // 메뉴 목록에서 요리의 이름들만 목록으로 추출
        List<String> collectedList = menuList.stream()
                .map(o -> o.getName())
                .collect(toList());

        System.out.println("=========================================");
        System.out.println("collectedList = " + collectedList);

        List<String> words = List.of(
                "safari", "chrome", "ms edge"
                , "opera", "firefox"
        );

        System.out.println();
        System.out.println("=========================================");
        System.out.println();

        List<Integer> result = words.stream()
                .map(w -> w.length())
                .collect(toList());

        System.out.println(result);

        System.out.println();
        System.out.println("=========================================");
        System.out.println();

        // 메뉴 목록에서 메뉴 이름과 칼로리를 추출하는데
        // 칼로리를 정수가 아닌 문자열로 kcal을 뒤에 붙여서 추출 후
        // 메뉴 이름 : xxxkcal 로 반복 출력하고싶음
        List<SimpleDish> list = menuList.stream()
//                .map(o -> new SimpleDish(o))
                .map(SimpleDish::new)
                .collect(toList());
        list.forEach(System.out::println);


        System.out.println();
        System.out.println("===================================");
        System.out.println();

        /*
            메뉴 목록에서 칼로리가 500칼로리보다 큰
            음식들을 필터링 한 다음에 음식의 이름과 타입만
            추출해서 출력
         */

        menuList.stream()
                .filter(o -> o.getCalories() > 500)
                .map(o -> o.getName() + " : " + o.getType())
                .forEach(System.out::println);

        System.out.println();
        System.out.println("===================================");
        System.out.println();

        // 메뉴 목록에 있는 요리들의 총 칼로리 수 구하기
        int sum = menuList.stream()
                .mapToInt(o -> o.getCalories())
                .sum();
        System.out.println("sum = " + sum);

        double averageCal = menuList.stream()
                .filter(o -> o.getType() == Dish.Type.MEAT)
                .mapToInt(o -> o.getCalories())
                .average()
                .getAsDouble();


    }
}
