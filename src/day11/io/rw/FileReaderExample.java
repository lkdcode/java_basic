package day11.io.rw;

import day11.io.Path;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader(Path.ROOT_PATH + "/메롱.txt")) {

//            int read = fr.read();

            // 버퍼 스트림
            BufferedReader br = new BufferedReader(fr);

            String s = br.readLine();
            System.out.println(s);

        } catch (FileNotFoundException e) {
            System.out.println("실!패!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("실패");
            e.printStackTrace();
        }

    }
}
