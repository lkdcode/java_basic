package day10.collection.music;

import java.util.*;

public class Singer {
    private String name;
    private Set<String> songList;

    private Singer() {
        this.songList = new HashSet<>();
    }

    public Singer(String name, String song) {
        this();
        this.name = name;
        this.songList.add(song);
    }

    public String getName() {
        return name;
    }

    public Set<String> getSongList() {
        return songList;
    }

    public void insertSong(String insertSong) {
        songList.add(insertSong);
    }
}
