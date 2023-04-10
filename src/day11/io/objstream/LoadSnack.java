package day11.io.objstream;

import day11.io.Path;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class LoadSnack {
    private static List<Snack> snackList = new ArrayList<>();

    public static void main(String[] args) {

        loadFile();
        for (Snack s : snackList) {
            System.out.println(s);
        }

    }

    private static void loadFile() {
        try (FileInputStream fis = new FileInputStream(Path.ROOT_PATH + "/snack.sav")) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            snackList = (List<Snack>) ois.readObject();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}