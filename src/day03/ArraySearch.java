package day03;

public class ArraySearch {
    static String[] foods = {"삼겹삼", "족발", "피자", "햄버거"};

    public static int indexOf(String target) {
        int index = 0;

        for (String food : foods) {
            if (food.equals(target)) return index;
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int index = indexOf("햄버거");
        System.out.println("index = " + index);

    }
}
