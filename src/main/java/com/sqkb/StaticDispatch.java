package com.sqkb;

/**
 * package: com.sqkb
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/14 下午3:36
 */
public class StaticDispatch {

    static abstract class Human {

    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello guy!");
    }

    public void sayHello(Man man) {
        System.out.println("hello man!");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello woman!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        StaticDispatch st = new StaticDispatch();

        st.sayHello(man);
        st.sayHello(woman);
    }
}