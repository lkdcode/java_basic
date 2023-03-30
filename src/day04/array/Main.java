package day04.array;

public class Main {
    public static void main(String[] args) {
        StringList foodList = new StringList("김치볶음밥", "삼겹살");
        StringList userNameList = new StringList("김씨");

        foodList.push("짜장면");
        foodList.push("볶음밥");
        foodList.push("탕수육");

        userNameList.push("김철수");
        userNameList.push("박영희");

        foodList.pop();
        userNameList.pop();

        foodList.clear();
        System.out.println("foodList.isEmpty() = " + foodList.isEmpty());


        System.out.println("foodList = " + foodList);
        System.out.println("foodList.size() = " + foodList.size());

        System.out.println("userNameList = " + userNameList);
        System.out.println("userNameList.size() = " + userNameList.size());

    }
}
