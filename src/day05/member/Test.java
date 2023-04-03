package day05.member;

public class Test {
    public static void main(String[] args) {

        MemberRepository memberRepository = new MemberRepository();

        Member newMember = new Member("jkl@def.com", "1234"
                , "쿵벌레", 4, Gender.MALE, 10);

        memberRepository.addMember(newMember);
        memberRepository.addMember(newMember);
        memberRepository.showMembers();

        // 수정 테스트
        String targetEmail = "ghi@def.com";
        boolean updateFlag = memberRepository.changePassword(targetEmail, "9999");

        if (updateFlag) {
            String updateMember = memberRepository.findByEmail(targetEmail).inform();
            System.out.println("updateMember = " + updateMember);
        } else {
            System.out.println("이메일이 잘 못 됨!");
        }

        memberRepository.showMembers();
        memberRepository.removeMember("jkl@def.com");
        memberRepository.showMembers();


    }
}