package day05.member;

public class Member {
    String email;
    String password;
    String memberName;
    int memberId;
    Gender gender;
    int age;

    public Member(String email, String password, String memberName, int memberId, Gender gender, int age) {
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.memberId = memberId;
        this.gender = gender;
        this.age = age;
    }

    // 회원정보를 문자열로 만들어서 리턴하는 기능
    String inform() {
        String convertGender = (gender == Gender.MALE) ? "남성" : "여성";

        return String.format("# %d번 | %s | %s | %s | %d세"
                , this.memberId, this.email, this.memberName
                , convertGender, this.age);
    }

}
