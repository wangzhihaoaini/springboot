package com.wangzhihao.springboot.exception;

/**
 * @ClassName StudentException
 * @Description TODO
 * @Author wangzhihao
 * @Date 19/11/1 21:24
 * @Version 1.0
 **/
public class StudentException extends RuntimeException{
    public StudentException() {
        super("自定义异常");
    }
}
