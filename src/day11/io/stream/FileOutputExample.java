package day11.io.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputExample {

    public static void main(String[] args) {
        String msg = "멍멍이는~~~ 왈왈~\n하하호호";

        // 데이터를 외부로 내보낼 때 출력 스트림

        try (FileOutputStream fos = new FileOutputStream("D:/exercise/dog.txt")) {
            fos.write(msg.getBytes());
            System.out.println("파일 저장에 성공!");

        } catch (FileNotFoundException e) {
            System.out.println("파일 저장 처리에 실패했습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("출력 시스템에 문제가 생겼습니다.");
            e.printStackTrace();
        }

//        finally {
//            try {
//                Objects.requireNonNull(fos).close();
//            } catch (IOException e) {
//                System.out.println("close 실패");
//                e.printStackTrace();
//            }
//        }

    }

}
