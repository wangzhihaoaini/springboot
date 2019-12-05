package com.wangzhihao.springboot.entity;

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
    private Object obj = null;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess() {
        this.success = true;
    }

    public void setFalse(){
        this.success=false;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
