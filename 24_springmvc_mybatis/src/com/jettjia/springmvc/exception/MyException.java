package com.jettjia.springmvc.exception;

/**
 * 自定义异常
 */
public class MyException extends Exception {
    // 异常信息
    private String msg;

    public MyException() {
        super();
    }

    public MyException(String msg) {
        super();
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
