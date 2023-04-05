package day08.poly.book;

import day05.member.Gender;

import java.util.Scanner;

import static day05.member.Gender.*;
import static day07.util.Utility.*;

public class LibraryView {
    private static Scanner sc;
    private static LibraryRepository repository;

    // static 데이터는 생성자에서 초기화하면 안 됨.
    // static 필드의 초기화는 static initializer 를 사용
    static {
        sc = new Scanner(System.in);
        repository = new LibraryRepository();
    }

    // 회원정보 입력처리
    private static void makeNewBookUser() {
        System.out.println("\n# 회원 정보를 입력해주세요.");
        String name = input("# 이름: ");
        int age = Integer.parseInt(input("# 나이: "));
        Gender gender = inputGender();

        // 입력받은 데이터 객체로 포장
        BookUser userInfo = new BookUser();
        userInfo.setName(name);
        userInfo.setAge(age);
        userInfo.setGender(gender);

        // 입력받은 유저객체를 저장소로 보내기
        repository.register(userInfo);
    }

    // 정확하게 성별을 입력할때까지 반복 입력받는 메서드
    private static Gender inputGender() {
        while (true) {
            String inputGender = input("# 성별(M/F): ");
            switch (inputGender.toUpperCase().charAt(0)) {
                case 'M':
                    return MALE;
                case 'F':
                    return FEMALE;
                default:
                    System.out.println("\n# 성별을 잘못 입력했습니다.");
            }
        }
    }

    // 화면 처리
    public static void start() {
        makeNewBookUser();

        // 메인 메뉴 띄우기
        while (true) {
            showMainScreen();
            selectMenu();
        }
    }

    // 메뉴 번호를 입력받고 분기를 나눠주는 메서드
    private static void selectMenu() {
        String menuNum = input("- 메뉴 번호: ");
        switch (menuNum) {
            case "1":
                // 마이페이지 : 가입한 회원정보 출력
                // 정보내놔
                BookUser user = repository.findBookUser();
                System.out.println("\n********** 회원님 정보 **********");
                System.out.println("# 회원명: " + user.getName());
                System.out.println("# 나이: " + user.getAge());
                System.out.println("# 성별: " + user.getGenderToString());
                System.out.println("# 쿠폰개수: " + user.getCouponCount());

                break;
            case "2":
                System.out.println("========= 모든 도서 정보 =========");
                for (String view : repository.getBookInfoList()) {
                    System.out.println(view);
                }
                //
                break;
            case "3":
                // 사용자에게 검색어를 입력받는다.
                String keyword = input("# 검색어: ");
                // 저장소에게 해당 검색어를 주면서
                // 검색에 걸린 책 정보를 내노라고 해야함
                String[] bookInfoList = repository.searchBookInfoList(keyword);

                if (bookInfoList.length > 0) {
                    System.out.printf("\n========= [%s] 검색 결과 =========\n", keyword);
                    for (String info : repository.searchBookInfoList(keyword)) System.out.println(info);
                } else {
                    System.out.println("\n# 검색 결과가 없습니다.");
                }
                break;
            case "4":
                // 대여 가능한 책의 목록을 번호화 함께 출력
                System.out.println("\n========= 대여 가능한 도서 목록 =========");
                String[] rentalList = repository.getBookInfoList();

                int bookNumber = 1;
                for (String info : rentalList) {
                    System.out.printf("%d. %s\n", bookNumber++, info);
                }
                String rentNumber = input("- 대여할 도서 번호 입력: ");
                RentStatus rentStatus = repository.rentBook(Integer.parseInt(rentNumber));

                if (rentStatus == RentStatus.RENT_SUCCESS_WITH_COUPON) {
                    System.out.println("# 성공적으로 요리책이 쿠폰발급과 함께 대여되었습니다.");
                } else if (rentStatus == RentStatus.RENT_SUCCESS) {
                    System.out.println("# 도서가 성공적으로 대여되었습니다.");
                } else {
                    System.out.println("# 도서 대여에 실패했습니다.");
                }

                break;
            case "5":
                // 도서 저자 이름으로 검색
                String author = input("# 검색어: ");

                String info = repository.findByAuthor(author);
                if (info.length() > 0) {
                    System.out.printf("\n========= [%s] 검색 결과 =========\n", author);
                    System.out.println(info);
                } else {
                    System.out.println("\n# 검색 결과가 없습니다.");
                }

                break;
            case "9":
                //
                System.out.println("# 프로그램을 종료합니다.");
                System.exit(0);
            default:
                System.out.println("\n# 메뉴 번호를 똑바로 입력하라고~~~");
        }

    }

    // 메인 메뉴창을 출력하는 메서드
    private static void showMainScreen() {
        System.out.println("============= 도서 매뉴 =============");
        System.out.println("# 1. 마이페이지");
        System.out.println("# 2. 도서 전체 조회");
        System.out.println("# 3. 도서 검색");
        System.out.println("# 4. 도서 대여하기");
        System.out.println("# 5. 도서 저자 이름으로 검색");
        System.out.println("# 9. 프로그램 종료하기");
    }

}