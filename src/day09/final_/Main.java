package day09.final_;

public class Main {
    public static void main(String[] args) {

        Person kim = new Person("김철수",
                "000111-31231234",
                new BagPack(5, "샘소나이트"));

        kim.name = "김출수";
//        kim.ssn = "021111-2222222";
//        kim.bagPack = new BagPack(10, "기본");
        Person park = new Person("박영희",
                "991111-1234567",
                null);

    }
}
