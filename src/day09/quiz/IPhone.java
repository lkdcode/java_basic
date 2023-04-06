package day09.quiz;

public class IPhone extends SmartPhone {

    @Override
    public String information() {
        return "아이폰은 Apple에서 만들어졌고 제원은 다음과 같다.\n"
                + takeCall() + "\n"
                + makeCall() + "\n"
                + takePicture() + "\n"
                + charge() + "\n"
                + touchDisplay() + "\n";
    }

    @Override
    public String charge() {
        return "고속충전, 고속 무선 충전";
    }

    @Override
    public String takePicture() {
        return "1200만, 1600만 트리플 카메라";
    }

    @Override
    public String makeCall() {
        return "전화받기 버튼을 누름";
    }

    @Override
    public String takeCall() {
        return "번호를 누르고 통화버튼을 누름";
    }

    @Override
    public String touchDisplay() {
        return "정전식";
    }
}
