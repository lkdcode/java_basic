package day10.exception;

public class FinallyExam {
    public static void main(String[] args) {

        String[] pets = {
                "비둘기",
                "거북이",
                "앵무새",
        };

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println("pets[i] = " + pets[i]);
            } catch (Exception e) {
                System.out.println("애완동물 정보가 없습니다.");
            } finally {
                System.out.println("애완동물~");

                // 데이터베이스 접속 후 다음 접속을 위해
                // 데이터베이스 연결을 종료시켜야 할 경우
            }
        }

        System.out.println("프로그램 정상 종료!");

    }
}
