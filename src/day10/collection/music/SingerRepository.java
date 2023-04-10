package day10.collection.music;

import java.io.*;
import java.util.*;

public class SingerRepository {

    // key : 가수의 이름, value : 가수 객체
    private static Map<String, Singer> singerList;

    static {
        singerList = new HashMap<>();
    }

    public SingerRepository() {
    }

    public Map<String, Singer> getSingerList() {
        return singerList;
    }

    public void insertSinger(String name, Singer singer) {
        singerList.put(name, singer);
    }


    // 자동 세이브 기능
    public void autoSave() {

        File file = new File("D:/music");
        if (!file.exists()) file.mkdir();

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("D:/music/m.sav")
        )) {

            oos.writeObject(singerList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 자동 로드 기능
    public void loadFile() {

        // 세이브 파일이 존재한다면
        File file = new File("D:/music/m.sav");
        if (file.exists()) {
            // 로드
            try (ObjectInputStream ois =
                         new ObjectInputStream(
                                 new FileInputStream(file)
                         )) {

                singerList = (Map<String, Singer>) ois.readObject();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

}