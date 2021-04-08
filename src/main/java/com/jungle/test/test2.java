package com.jungle.test;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test2 {
    public static void main(String[] args) {
        
        /**
         * 时间格式化
         */
        Date now = new Date();
        System.out.println("当前时间>>>"+now);
        //线程不安全 并发
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(now));

        /**
         * 字符串运用
         */
        String str = "ahdkkf";

        // startsWith endsWith
        System.out.println(str+"是否以a开头"+str.startsWith("a"));
        System.out.println(str+"是否以f结尾"+str.endsWith("f"));

        String str2 = "kccccc";

        // indexof lastIndexof  索引
        System.out.println("c第一次出现的位置"+str2.indexOf("c"));
        System.out.println("c最后一次出现的位置"+str2.lastIndexOf("c"));

        //replace 替换
        String new_str2 = str2.replace("c","a");
        System.out.println(new_str2);

        // toLowerCase() toUpperCase 转换大小写
        System.out.println(str2.toUpperCase());

        // trim() 消除多余空格
        String acc = "admin ";
        System.out.println(acc); //输出末尾有空格
        System.out.println(acc.trim()); //输出末尾无空格
    }
}
