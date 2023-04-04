package day07.static_;

import day07.util.Utility;

import static day07.util.Utility.makeLine;
import static java.lang.System.*;

// static 필드와 메서드를 그냥 참조 가능


public class Main {
    public static void main(String[] args) {

        out.println(Count.x);

        Count.m1();

        Count c1 = new Count();
        Count c2 = new Count();

        c2.m2();

        Count.x = 10;
        c2.y = 20;

        Count.x++;

        out.printf("c1 = x: %d, y: %d\n", c1.x, c1.y);
        out.printf("c2 = x: %d, y: %d\n", c2.x, c2.y);

        Calculator cal1 = new Calculator();
        Calculator cal2 = new Calculator();

        cal1.color = "빨강";
        cal2.color = "초록";

        out.println("cal2 = " + cal2);

        double result = Calculator.calcAreaCircle(5);

        makeLine();


    }
}
