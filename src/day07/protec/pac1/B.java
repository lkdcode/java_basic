package day07.protec.pac1;

public class B {

    void test() {
        A a1 = new A(1);
        A a2 = new A("set");

        a1.f1 = 1;
        a1.f2 = 2;

        a1.m1();
        a1.m2();
    }


}
