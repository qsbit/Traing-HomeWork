package com.jungle.common;

public class Result {
    private Integer code;
    private String msg;
    private Object list;

    public Result() {
    }

    public Result(Integer code, String msg, Object list) {
        this.code = code;
        this.msg = msg;
        this.list = list;
    }

    public static Result setSucceed(Object list){
        return new Result(StatusCode.success,"请求成功",list);
    }

    public static Result setError(){
        return new Result(StatusCode.error,"请求失败",null);
    }

    public static Result setLoginError(){
        return new Result(StatusCode.Login_error,"登录失败",null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", list=" + list +
                '}';
    }
}

