package day10.collection.music;

import java.util.Scanner;

public class InputView {
    private Scanner sc;

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public String menuNumber() {
        return sc.nextLine();
    }

    public String singerName() {
        return sc.nextLine();
    }

    public String songName() {
        return sc.nextLine();
    }

}