package day05.member;

import java.util.Scanner;

/**
 * 역할 : 회원 관리 앱의 입,출력을 담당
 */
public class MemberView {
    Scanner sc;
    MemberRepository mr;

    public MemberView() {
        this.sc = new Scanner(System.in);
        this.mr = new MemberRepository();
    }

    /**
     * 초기 메인 화면을 출력
     */
    void mainView() {
        System.out.println("\n##### 회원 관리 시스템 #####");
        System.out.println("* 1. 회원 정보 등록하기");
        System.out.println("* 2. 개별 회원 정보 조회하기");
        System.out.println("* 3. 전체 회원 정보 조회하기");
        System.out.println("* 4. 회원 정보 수정하기");
        System.out.println("* 5. 회원 정보 탈퇴하기");
        System.out.println("* 6. 프로그램 끝내기");
        System.out.println("===========================");
    }

    /**
     * 프로그램 화면 흐름을 제어하는 기능
     */
    void viewProcess() {
        while (true) {
            mainView();
            String menuNum = input(">> ");

            switch (menuNum) {
                case "1":
                    signUp();
                    break;
                case "2":
                    showDetailMember();
                    stop();
                    break;
                case "3":
                    mr.showMembers();
                    stop();
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    String answer = input("# 정말로 종료합니까? [y/n]");
                    if (answer.toLowerCase().charAt(0) == 'y') {
                        System.out.println("# 프로그램을 종료합니다.");
                        System.exit(0);
                    } else {
                        continue;
                    }
                    break;
                default:
                    System.out.println("\n# 매뉴 번호를 다시 입력하세요.");
            }

        }


    }

    String input(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    /**
     * 엔터를 누르기전까지 멈추는 기능
     */
    void stop() {
        System.out.println("\n============= 엔터를 눌러서 계속... =============");
        sc.nextLine();
    }

    // 회원 등록 입력 처리
    void signUp() {
        System.out.println("\n# 회원 등록을 시작합니다!!");
        String email;
        while (true) {
            email = input("# 이메일 : ");
            if (!mr.isDuplicateEmail(email)) break;
            System.out.println("# 중복된 이메일입니다.");
        }

        String name = input("# 이름 : ");
        String password = input("# 패스워드 : ");

        Gender gender;

        checkGender:
        while (true) {
            String inputGender = input("# 성별[M/F] : ");

            switch (inputGender.toUpperCase().charAt(0)) {
                case 'M':
                    gender = Gender.MALE;
                    break checkGender;
                case 'F':
                    gender = Gender.FEMALE;
                    break checkGender;
                default:
                    System.out.println("# 성별을 M/F로 정확히 입력하세요");
            }

        }
        int age;
        while (true) {
            try {
                age = Integer.parseInt(input("# 나이 : "));
                break;
            } catch (NumberFormatException e) {
                System.out.println("# 나이를 제대로 입력하세요.");
            }
        }
        mr.addMember(new Member(email, password, name, (mr.getLastMemberId() + 1), gender, age));

        System.out.println("\n# 회원 가입 성공!!");
        stop();
    }


    // 회원 개별조회를 위한 입출력처리
    void showDetailMember() {
        // 이메일 입력하세요!
        System.out.println("\n# 이메일을 입력하세요!");
        // 찾은 회원의 정보
        Member member = mr.findByEmail(input(">> "));

        if (member != null) {
            System.out.println("======== 조회결과 ========");
            System.out.println("# 이름 : " + member.memberName);
            System.out.println("# 비밀번호 : " + member.password);
            System.out.println("# 성별 : " + (member.gender == Gender.MALE ? "남성" : "여성"));
            System.out.println("# 나이 : " + member.age);
        } else System.out.println("# 회원이 존재하지 않습니다.");

    }


}