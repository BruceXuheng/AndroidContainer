package com.study.test.testapplication.singledemo;

public class Singleton {

    private static class InnerClass{
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance(){
        return InnerClass.singleton;
    }

    private Singleton(){}

}
