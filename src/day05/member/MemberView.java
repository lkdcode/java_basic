package day05.member;

import java.util.Scanner;

import static day05.member.Gender.*;
import static java.lang.System.*;

/**
 * 역할 : 회원 관리 앱의 입,출력을 담당
 */
public class MemberView {
    Scanner sc;
    MemberRepository mr;

    public MemberView() {
        this.sc = new Scanner(in);
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
                    changePasswordViewProcess();
                    break;
                case "5":
                    removeMemberViewProcess();
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

    private void removeMemberViewProcess() {
        // 이메일 입력받기
        String email = input("# 삭제할 이메일을 입력해주세요.");
        mr.removeMember(email);

        // 존재하는지 확인 후 삭제 처리 위임
        int memberIndex = mr.findIndexByEmail(email);

        if (memberIndex != -1) {
            // -> 한번 더 y/n 으로 삭제여부 묻기
            String order = input("# 정말 삭제하시겠습니까? [y/n]");
            if (order.equalsIgnoreCase("y")) {
                mr.removeMember(email);
            } else {
                System.out.println("# 삭제를 취소하였습니다.");
            }
        } else {
            System.out.println("# 해당 이메일은 존재하지 않습니다.");
        }

        stop();
    }

    // 비밀번호 변경 입출력 처리
    void changePasswordViewProcess() {
        String email = input("# 수정할 대상의 이메일: ");
        Member foundMember = mr.findByEmail(email);

        if (foundMember != null) {
            // 수정 진행
            System.out.printf("%s님의 비밀번호를 변경합니다!\n", foundMember.memberName);
            // 기존 비밀번호와 같으면 변경 취소
            String newPassword = input("# 새로운 비밀번호: ");
            if (foundMember.password.equals(newPassword)) {
                System.out.println("# 기존 비밀번호와 같습니다!");
                return;
            }
            mr.changePassword(email, newPassword);
            System.out.println("\n# 비밀번호가 성공적으로 수정되었습니다.");
        } else {
            System.out.println("\n# 조회 결과가 없습니다.");
        }

        stop();
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
                    gender = MALE;
                    break checkGender;
                case 'F':
                    gender = FEMALE;
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
            System.out.println("# 성별 : " + (member.gender == MALE ? "남성" : "여성"));
            System.out.println("# 나이 : " + member.age);
        } else System.out.println("# 회원이 존재하지 않습니다.");

    }
}