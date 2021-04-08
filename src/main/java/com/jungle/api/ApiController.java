package com.jungle.api;

import com.jungle.common.Result;
import com.jungle.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ApiController extends Result{
    @ResponseBody
    @GetMapping("/init") //拦截器
    public String init(){
        return "happy everyday!!!";
    }

    @ResponseBody
    @RequestMapping(value = {"/init2","/init4"} ,method = RequestMethod.POST)
    public String init2(){
        return "hello init2,4!";
    }

    @ResponseBody
    @RequestMapping(value = "/init3")
    public String init3(){
        return "Hello init3";
    }

    @ResponseBody
    @RequestMapping(value = "/init5" , method = RequestMethod.POST,params = {"name=zs"})
    public String init5(){
        return "hello 5";
    }

    @ResponseBody
    @RequestMapping(value = "/init6" , method = RequestMethod.POST,params = {"age!=23"}) //不等于23
    public String init6(){
        return "hello 6";
    }

    @ResponseBody
    @RequestMapping(value = "/init7" , method = RequestMethod.POST,params = {"!id"}) //不存在
    public String init7(){
        return "hello 7";
    }

    @ResponseBody
    @RequestMapping(value = "/init8/*/ss", method = RequestMethod.GET) //通配符
    public String init8(){
        return "hello 8";
    }

    @ResponseBody
    @RequestMapping(value = "/init9/{name}/{age}", method = RequestMethod.GET)
    public String init9(@PathVariable String name, @PathVariable int age){
        System.out.println("name:"+name+"age:"+age);
        return "hello 9";
    }

    /*
    * code:200
    * msg:""
    * data:Object 响应的字符集
    * */
    @ResponseBody
    @RequestMapping("/getAllStudent/{value}")
    public Result getPush(@PathVariable int value) {
        //业务逻辑
        //查询所有学生 list student
        List<Student> list = new ArrayList<>();
        Student s1 = new Student(123, "zs", 20);
        Student s2 = new Student(124, "ww", 28);
        list.add(s1);
        list.add(s2);

        if (value == 1){
            return setSucceed(list); //请求成功

        }else if (value == 2){
            return setError();//请求失败
        }else {
            return setLoginError(); //登录失败
        }
    }
}


