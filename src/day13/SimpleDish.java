package day13;

// 요리 정보 중에 이름과 칼로리만 관리하는 객체
public class SimpleDish {

    private final String name;
    private final String calories;

    public SimpleDish(String name, String calories) {
        this.name = name;

        this.calories = calories;
    }

    public SimpleDish(Dish dish) {
        this.name = dish.getName();
        this.calories = String.valueOf(dish.getCalories());
    }

    public String getName() {
        return name;
    }

    public String getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return name + " : " + calories + "kcal";
    }
}
