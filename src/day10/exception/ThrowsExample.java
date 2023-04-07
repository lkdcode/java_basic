package day10.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsExample {
    // 정수를 입력받아서 리턴하는 메서드
    public int inputNumber() throws InputMismatchException {
        return new Scanner(System.in).nextInt();
    }

    // 문자열을 정수로 변환하는 기능
    public int convert(String s) throws NumberFormatException, NullPointerException {
        return Integer.parseInt(s);
    }

    public void convertAndInput() {
        try {
            int n = inputNumber();
            int m = convert("100");
        } catch (InputMismatchException e) {
            System.out.println("정수 입력 잘 해라");
        } catch (NumberFormatException e) {
            System.out.println("숫자변환 못함");
        }
    }
}
