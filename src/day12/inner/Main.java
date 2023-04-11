package day12.inner;

public class Main {

    // 내부 클래스 (inner class)
    public static class SubCalculator implements Calculator {

        @Override
        public int operate(int n1, int n2) {
            if (n1 >= n2) {
                return n1 - n2;
            }
            return n2 - n1;
        }
    }

    public static void main(String[] args) {
        // 덧셈 계산을 하는 계산기를 만들어서 쓰고 싶다.

        Calculator calculator = new AddCalculator();
        int result = calculator.operate(52, 62);
        System.out.println("result = " + result);

        // 뺄셈 계산을 하는 계산기가 필요
        SubCalculator sub1 = new SubCalculator();
        System.out.println(sub1.operate(100, 20));

        // 곱셈 계산을 하는 계산기가 필요 (익명 클래스)
        Calculator multiCal = new Calculator() {
            @Override
            public int operate(int n1, int n2) {
                return n1 * n2;
            }
        };

        System.out.println(multiCal.operate(5, 7));

        // 나눗셈을 하는 계산기 (람다) : 인터페이스의 추상 메서드가 딱 1개일때만
        Calculator divCal = (o1, o2) -> o1 / o2;
        System.out.println(divCal.operate(50, 10));

        // 1회용 강아지
        Pet dog = new Pet() {
            @Override
            public void eat() {
                System.out.println("강아지는 개사료를 먹어요");
            }

            @Override
            public void play() {
                System.out.println("강아지는 마당에서 놀아요");
            }
        };

    }
}
