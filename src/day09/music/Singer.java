package day09.music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Singer {
    private String name;
    private List<String> songList;

    private Singer() {
        this.songList = new ArrayList<>();
    }

    public Singer(String name, String song) {
        this();
        this.name = name;
        this.songList.add(song);
    }

    public String getName() {
        return name;
    }

    public List<String> getSongList() {
        return Collections.unmodifiableList(songList);
    }

    public void insertSong(String insertSong) {
        songList.add(insertSong);
    }
}
