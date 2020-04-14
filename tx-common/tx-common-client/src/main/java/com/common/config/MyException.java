package com.common.config;

/**
 * @description: 自意义异常状态，信息
 * @author: kws
 * @date: 2019/8/16
 */
public class MyException extends RuntimeException{

    // 自定义异常代码
    private int status = 503;
    // 构造方法
    public MyException(String message, int status) {
        super(message);
        this.status = status;
    }
}
