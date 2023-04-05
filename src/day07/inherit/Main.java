package day07.inherit;

import java.util.HashSet;
import java.util.Set;

import static day07.util.Utility.makeLine;

public class Main {
    public static void main(String[] args) {
        Warrior w = new Warrior("주차왕파킹");
        Mage m = new Mage("충격왕쇼킹");
        Hunter h = new Hunter("욕설왕퍼킹");

        Player[] players = {
                w, h, m,
                new Mage("썬법"),
                new Warrior("토끼곤듀"),
                new Warrior("딸긔곤듀"),
                new Hunter("겅듀곤듀")
        };

        m.thunderBolt(
                w, h, m,
                new Mage("썬법"),
                new Warrior("토끼곤듀"),
                new Warrior("딸긔곤듀"),
                new Hunter("겅듀곤듀")
        );


    }
}
