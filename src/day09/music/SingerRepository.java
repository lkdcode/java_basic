package day09.music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingerRepository {
    private List<Singer> singerList;

    public SingerRepository() {
        this.singerList = new ArrayList<>();
    }

    public List<Singer> getSingerList() {
        return Collections.unmodifiableList(singerList);
    }

    public void insertSinger(Singer singer) {
        this.singerList.add(singer);
    }

}
