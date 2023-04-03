package day06.modi.pac2;

import day06.modi.pac1.A;

public class C {

    void test() {
        A a = new A(); // public
//        A a1 = new A(1); // default
//        A a2 = new A("t"); // private

        a.f1 = 1;
//        a.f2 = 2;
//        a.f3 = 3;

        a.m1();
//        a.m2();
//        a.m3();

//        B b = new B();
//        b.x1 = 1;
    }

}