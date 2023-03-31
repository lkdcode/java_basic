package day05.member;

public class Test {
    public static void main(String[] args) {

        MemberRepository memberRepository = new MemberRepository();

        Member newMember = new Member("jkl@def.com", "1234"
                , "쿵벌레", 4, Gender.MALE, 10);

        memberRepository.addMember(newMember);
        memberRepository.addMember(newMember);
        memberRepository.showMembers();

    }
}
