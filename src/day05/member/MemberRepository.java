package day05.member;

public class MemberRepository {
    Member[] memberList;

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
//         이메일이 중복인가??
        if (isDuplicateEmail(newMember.email)) return false;

        // 실제로 멤버를 추가하는 코드
        Member[] temp = new Member[memberList.length + 1];
        for (int i = 0; i < memberList.length; i++) {
            temp[i] = memberList[i];
        }
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
        Member temp=null;
        for (Member member : memberList) {
            if (email.equals(member.email)) {
                temp = member;
            }
        }
        return temp;
    }

}