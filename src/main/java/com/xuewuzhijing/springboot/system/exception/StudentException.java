package com.xuewuzhijing.springboot.system.exception;

/**
 * @ClassName StudentException
 * @Description TODO
 * @Author xuewuzhijing
 * @Date 19/11/1 21:24
 * @Version 1.0
 **/
public class StudentException extends RuntimeException{
    public StudentException() {
        super("自定义异常");
    }
}
