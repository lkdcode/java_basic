package day04;

// 실행용 클래스
// 여기엔 설계를 하지 않고 main 메서드를 작성합니다.
public class DancerMain {
    public static void main(String[] args) {
        Dancer kim = new Dancer();
//        kim.dancerName = "김관종";
//        kim.crewName = "서커스크루";
        Dancer 장동견 = new Dancer("장동견", "목각댄스", DanceLevel.PRO);

        System.out.println(kim.introduce());

        Singer song = new Singer(new String("original"));


    }
}
