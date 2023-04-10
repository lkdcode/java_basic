package day05.member;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class MemberRepository {
    public static final int NOT_FOUND = -1;
    // 가입된 회원 배열
    Member[] memberList;

    // 삭제된 회원 배열
    Member[] removeMember;

    public MemberRepository() {
        this.memberList = new Member[3];
        memberList[0] = new Member("abc@def.com", "1234"
                , "콩벌레", 1, Gender.MALE, 50);
        memberList[1] = new Member("def@def.com", "1234"
                , "벌레콩", 2, Gender.FEMALE, 30);
        memberList[2] = new Member("ghi@def.com", "1234"
                , "레콩벌", 3, Gender.FEMALE, 20);
    }

    /**
     * 모든 회원 정보를 출력해주는
     */
    void showMembers() {
        System.out.printf("============= 현재 회원정보 (총 %d명) =============\n"
                , memberList.length);
        for (Member member : memberList) {
            System.out.println(member.inform());
        }
    }

    /**
     * 회원 가입 기능
     *
     * @param newMember : 새롭게 회원가입하는 회원의 정보
     * @return : 회원 가입 성공 여부
     * 성공시 true, 이메일이 중복되어 실패시 false
     */
    boolean addMember(Member newMember) {
        // 이메일이 중복인가??
        if (isDuplicateEmail(newMember.email)) return false;

        // 실제로 멤버를 추가하는 코드
        Member[] temp = new Member[memberList.length + 1];
        for (int i = 0; i < memberList.length; i++) {
            temp[i] = memberList[i];
        }

        // svae 파일 생성
        try (FileWriter fw = new FileWriter("D:/exercise/member.txt")) {

            String saveInfo = "";
            saveInfo += newMember.memberId;
            saveInfo += newMember.email;
            saveInfo += newMember.memberName;
            saveInfo += newMember.password;
            saveInfo += newMember.gender;
            saveInfo += newMember.age;

            fw.append(saveInfo).append("\n");
        } catch (IOException e) {
            System.out.println("파일 저장 실패!");
            e.printStackTrace();
        }


        // 회원 가입 시간 등록
        newMember.regDate = LocalDate.now();

        temp[memberList.length] = newMember;
        memberList = temp;

        return true;
    }

    /**
     * 이메일의 중복 여부를 확인하는 기능
     *
     * @param targetEmail : 검사 대상 이메일
     * @return : 중복 되었을 시 true, 사용 가능할 시 false
     */
    boolean isDuplicateEmail(String targetEmail) {
        for (Member member : memberList) {
            if (member.email.equals(targetEmail)) return true;
        }
        return false;
    }

    /**
     * 마지막회원의번호를아렬주는
     */

    int getLastMemberId() {
        return memberList[memberList.length - 1].memberId;
    }

    /**
     * 이메일틍 통해 특정 회원 객체를 찾아서 반환하는 기능
     *
     * @param email : 찾고 싶은 회원의 이메일
     * @return : 찾은 회원의 객체 정보, 못 찾으면 null 반환
     */
    Member findByEmail(String email) {
        Member temp = null;
        for (Member member : memberList) {
            if (email.equals(member.email)) {
                temp = member;
            }
        }
        return temp;
    }

    /**
     * 이메일을 통해 저장된 회원의 인덱스 값을 알아내는 메서드
     *
     * @param email : 탐색 대상의 이메일
     * @return : 찾아낸 인덱스, 못 찾으면 -1 리턴
     */
    int findIndexByEmail(String email) {
        for (int i = 0; i < memberList.length; i++) {
            if (memberList[i].email.equals(email)) return i;
        }
        return NOT_FOUND;
    }

    /**
     * 비밀번호를 수정하는 기능
     *
     * @param email       : 수정 대상의 이메일
     * @param newPassword : 변경할 새로운 비밀번호
     */
    boolean changePassword(String email, String newPassword) {
        // 인덱스 탐색
        int index = findIndexByEmail(email);
        // 수정 진행
        if (index == NOT_FOUND) return false;

        memberList[index].password = newPassword;
        return true;
    }

    void removeMember(String email) {
        // 인덱스 찾기
        int index = findIndexByEmail(email);

        if (index == NOT_FOUND) return;
        Member[] temp = new Member[memberList.length - 1];

        // 1칸 밀기
        for (int i = 0, j = 0; i < memberList.length; i++) {
            if (i == index) continue;
            temp[j++] = memberList[i];
        }

        memberList = temp;
    }

    boolean isEmpty() {
        return memberList.length == 0;
    }

}