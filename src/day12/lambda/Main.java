package day12.lambda;

import day05.member.Gender;
import day05.member.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static day12.lambda.Color.*;
import static day12.lambda.FilterApple.*;
import static day12.lambda.MappingApple.*;

public class Main {

    public static void main(String[] args) {

        // 사과 바구니 생성
        List<Apple> appleBasket = List.of(
                new Apple(80, GREEN)
                , new Apple(97, RED)
                , new Apple(155, GREEN)
                , new Apple(50, YELLOW)
                , new Apple(120, RED)
                , new Apple(64, GREEN)
                , new Apple(21, YELLOW)
                , new Apple(73, RED)
        );

        System.out.println("============== 녹색 사과 필터링 ==============");

        List<Apple> greenApples = filterGreenApples(appleBasket);
        for (Apple greenApple : greenApples) {
            System.out.println("greenApple = " + greenApple);
        }

        System.out.println("============== 노란 사과 필터링 ==============");
        List<Apple> greenApples1 = filterApplesByColor(appleBasket, YELLOW);
        for (Apple apple : greenApples1) {
            System.out.println("apple = " + apple);
        }
        System.out.println("============== 원하는 조건으로 필터링 1 ==============");

        // 100g 이하 사과들
        List<Apple> filterApples = filterApples(appleBasket, new LightApplePredicate());

        for (Apple filterApple : filterApples) {
            System.out.println("filterApple = " + filterApple);
        }

        System.out.println("============== 원하는 조건으로 필터링 2 ==============");
        // 빨강 사과 필터링
        List<Apple> redApples = filterApples(appleBasket, apple -> apple.getColor() == RED);

        for (Apple redApple : redApples) {
            System.out.println("redApple = " + redApple);
        }

        System.out.println("============== 원하는 조건으로 필터링 3 ==============");

        // 녹색 이면서 100g보다 큰 사과들만 필터링 (익명)
        List<Apple> testApples = filterApples(appleBasket, apple -> apple.getColor() == GREEN);
        testApples = filterApples(testApples, apple -> apple.getWeight() > 100);

        for (Apple testApple : testApples) {
            System.out.println("testApple = " + testApple);
        }

        System.out.println("============== 원하는 조건으로 필터링 4 ==============");

        List<Apple> filteredAppleList = filter(appleBasket, apple ->
                apple.getWeight() >= 100
                        && apple.getWeight() <= 150);

        for (Apple apple : filteredAppleList) {
            System.out.println("apple = " + apple);
        }

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> filteredNumbers = filter(numbers, n -> n % 2 == 0);
        for (Integer filteredNumber : filteredNumbers) {
            System.out.println("filteredNumber = " + filteredNumber);
        }

        List<String> wordList = List.of(
                "moments", "hello", "apple", "banana", "ace"
                , "base", "zebra"
        );

        List<String> filteredWordList = filter(wordList, w -> w.length() == 5);
        System.out.println("filteredWordList = " + filteredWordList);

        List<String> filteredWordList2
                = wordList.stream()
                .filter(w -> w.length() < 5)
                .filter(w -> w.contains("a"))
                .collect(Collectors.toList());

        System.out.println("filteredWordList2 = " + filteredWordList2);


        System.out.println("============== 원하는 조건으로 맵링 ==============");

        List<Color> colors = mappingAppleByColor(appleBasket);

        System.out.println("colors = " + colors);

        // 회원 정보에서 회원의 닉네임만 추출
        System.out.println("============== 원하는 조건으로 맵링2 ==============");
        List<Member> memberList = List.of(
                new Member("231244.eom", "1263634", "nam235e", 234, Gender.MALE, 1123)
                , new Member("231244.eom", "12334", "n21`23ame", 4134, Gender.MALE, 1253)
                , new Member("23111244.eom", "13234", "na`3me", 334, Gender.MALE, 1223)
                , new Member("212434.eom", "146234", "n123ame", 314, Gender.MALE, 12523)
                , new Member("2`131244.eom", "1234634", "n4125ame", 3144, Gender.MALE, 1243)
                , new Member("2`312334.eom", "123634", "n125ame", 344, Gender.MALE, 1823)
        );

        List<Gender> mapList = map(memberList, new GenericFunction<Member, Gender>() {
            @Override
            public Gender apply(Member m) {
                return m.gender;
            }
        });

        System.out.println("mapList = " + mapList);
    }
}
