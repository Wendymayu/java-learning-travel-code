package com.wendy.basic.advanced_feature.exceptionPrac;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/17 23:27
 * @Version 1.0
 */
public class MyException extends Exception{
    //private String message;

    public MyException(String msg) {
        super("出现异常：" + msg);
        //this.message = msg;
    }
}
