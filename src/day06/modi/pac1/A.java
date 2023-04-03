package day06.modi.pac1;

public class A {
    // 클래스의 멤버
    // 필드
    public int f1;
    int f2;
    private int f3;

    // 메서드
    public void m1() {
    }

    void m2() {
    }

    private void m3() {
    }

    // 생성자
    public A() {
        f1 = 1;
        f2 = 2;
        f3 = 3;
        m1();
        m2();
        m3();

        new A();
        new A(3);
        new A("st");

        B b = new B();
        b.x1 = 1;
        b.x2 = 2;
//        b.x3 = 3;
    }

    A(int a) {

    }

    private A(String a) {

    }
}