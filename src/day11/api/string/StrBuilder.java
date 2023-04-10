package day11.api.string;

public class StrBuilder {
    private static void makeString() {
        long start = System.currentTimeMillis();

        String s = "";
        for (int i = 0; i < 500000; i++) {
            s += "A";
        }

        long end = System.currentTimeMillis();
        System.out.println("String 총 소요 시간 = " + (end - start) + "밀리초");
    }

    private static void makeStringBuilder() {
        long start = System.currentTimeMillis();

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 500000; i++) {
            s.append("A");
        }

        long end = System.currentTimeMillis();
        System.out.println("StringBuilder 총 소요 시간 = " + (end - start) + "밀리초");
    }

    public static void main(String[] args) {
        makeString();
        makeStringBuilder();

        Integer a = 10; // 오토 박싱
        Character c = 'A';

        Byte b = 1;
        Short C = 3;
        Long l = 3L;
        Double D = 3.1;


    }
}
