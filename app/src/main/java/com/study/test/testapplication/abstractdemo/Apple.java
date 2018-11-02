package com.study.test.testapplication.abstractdemo;

public class Apple extends AbsPen{

    public void execute(String message){

        manage(message);
    }

    @Override
    public void getMessage(String msg) {
        System.out.print(msg);
    }
}
