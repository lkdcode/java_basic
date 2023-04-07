package day10.collection.music;

import java.util.*;

public class SingerRepository {

    // key : 가수의 이름, value : 가수 객체
    private static Map<String, Singer> singerList;

    static {
        singerList = new HashMap<>();
    }

    public SingerRepository() {
    }

    public List<Singer> getSingerList() {
        return null;
    }

    public void insertSinger(String name, Singer singer) {
        singerList.put(name, singer);
    }

}