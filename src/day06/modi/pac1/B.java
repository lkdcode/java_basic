package day06.modi.pac1;

class B { // default 제한 : 클래스에는 public 과 default 만 사용 가능
    public int x1;
    int x2;
    private int x3;

    void test() {
        A a = new A();
        A a1 = new A(10);
//        A a2 = new A("zzz");

        a.f1 = 1;
        a.f2 = 2;
//        a.f3 = 3;

        a.m1();
        a.m2();
//        a.m3();
    }

}
