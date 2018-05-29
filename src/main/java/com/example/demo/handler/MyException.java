package com.example.demo.handler;

/**
 * Created by PengHongfu 2018-05-29 14:57
 */
public class MyException extends RuntimeException {

    public MyException(){
        super();
    }
    public MyException(String msg){
        super(msg);
    }
}
