package day10.collection.map;

import day09.music.Singer;

import java.util.HashMap;
import java.util.Map;

import static day07.util.Utility.makeLine;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();

        // put(K, V) : 데이터 추가
        map.put("지갑잔액", 5000);
        map.put("좋아하는 가수", new Singer(null, null));
        map.put("짜장면", 3000);
        map.put("저녁메뉴", "볶음밥");

        System.out.println("map = " + map);
        System.out.println(map.size());

        // get(key) : 데이터 참조
        String dinner = (String) map.get("저녁메뉴");
        System.out.println("dinner = " + dinner);

        dinner = dinner.toUpperCase();
        System.out.println("dinner = " + dinner);

        Singer singer = (Singer) map.get("좋아하는 가수");
        System.out.println("singer = " + singer.toString());

        System.out.println("map = " + map);
        map.put("저녁메뉴", "짬뽕");
        System.out.println("map = " + map);

        for (String key : map.keySet()) {
            System.out.println("key = " + key);
            System.out.println("value = " + map.get(key));
            makeLine();
        }


    }
}
