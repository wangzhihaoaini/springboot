package com.wangzhihao.springboot.common.entity;

/**
 * @description：操作结果集
 * @author：wangzhihao
 * @date：2019/11/29 14:53
 */
public class Result{
    public static final int SUCCESS = 1;
    public static final int FAILURE = -1;
    private boolean success;
    private String msg = "";
    private Object object = null;

    public Result() {
    }

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
