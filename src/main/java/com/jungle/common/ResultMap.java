package com.jungle.common;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {

    //构造方法
    public  ResultMap() {

    }
    //请求成功
    public static Map<String,Object> succeedMap(Object list){
        Map<String,Object> succeedMap = new HashMap<>();
        succeedMap.put("code", StatusCode.success);
        succeedMap.put("msg","请求成功");
        succeedMap.put("data", list);
        return succeedMap;
    }
    //请求失败
    public static Map<String,Object> errorMap(){
        Map<String,Object> errorMap = new HashMap<>();
        errorMap.put("code", StatusCode.error);
        errorMap.put("msg", "请求失败");
        errorMap.put("data", null);
        return errorMap;
    }
    //登录失败
    public static Map<String,Object> loginError(){
        Map<String, Object> login_map = new HashMap<>();
        login_map.put("code", StatusCode.Login_error);
        login_map.put("msg", "登录失败");
        login_map.put("data", null);
        return login_map;
    }
}
