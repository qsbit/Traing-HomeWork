package com.jungle.controller;

import com.jungle.common.Result;
import com.jungle.common.StatusCode;
import com.jungle.entity.User;
import com.jungle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
//注解
//控制器，controller通过接收前端传过来的参数进行业务操作，再将处理结果返回到前端
@Controller
public class UserController implements WebMvcConfigurer {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    //默认为登录页
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login");
    }

    //登录界面
    @RequestMapping("/login")  //@RequestMapping 来映射请求，也就是通过它来指定控制器可以处理哪些URL请求
    public String textLogin(){
        return "login";
    }

    //用户登录信息判断
    @ResponseBody  //@ResponseBody的作用其实是将java对象转为json格式的数据
    @RequestMapping("/user/login")
    public Result userLogin(String userAccount, String password){
        //非空判断
        if(userAccount=="" || userAccount==null){
            return new Result(StatusCode.error,"账号不能为空",null);
        }
        if(password=="" || password==null){
            return new Result(StatusCode.error,"密码不能为空",null);
        }

        User user = userService.findUserByUserAccountAndPassword(userAccount,password);
        if(user!=null){
            request.getSession().setAttribute("userId",user.getId());
            return new Result(StatusCode.success,"登录成功",user);
        }
        return new Result(StatusCode.error,"登录失败",null);
    }


    //注册界面
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    //图表页面
    @RequestMapping("/echarts")
    public String echarts(){
        return "charts";
    }

    //男女用户数量统计  条形图
    @ResponseBody
    @RequestMapping("/userGender")
    public List<Map<String,Object>> userGender(){
        List<Map<String,Object>> userGenderNum = userService.userGenderNum();
        return userGenderNum;
    }

    //统计年龄段
    @ResponseBody
    @RequestMapping("/userAge")
    public List<Map<String,Object>> userAge(){
        List<Map<String,Object>> userAgeNum = userService.userAgeNum();
        return userAgeNum;
    }


    //当前用户个人信息
    @RequestMapping("/userInfo")
    public String userInfo(Model model){
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");   //用session对象存储用户id
        if (userId==null || userId==0){
            return "redirect:/pages/login.jsp";
        }
        System.out.println("当前会话的用户对象id>>>"+userId);
        User userInfo = userService.findUserById(userId);
        model.addAttribute("userInfo",userInfo);

        return "userinfo";
    }

    //进入添加用户界面
    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "addUser";
    }

    //添加用户
    @ResponseBody
    @RequestMapping("/addUser")
    public Result addUser(String userAccount,String userName,String password,Integer age,String gender){

        if(userAccount=="" || userAccount==null){
            return new Result(StatusCode.error,"账号不能为空",null);
        }
        if(userName==""||userName==null){
            return new Result(StatusCode.error,"用户名不能为空",null);
        }
        if(password==""||password==null){
            return new Result(StatusCode.error,"密码不能为空",null);
        }
        User exist = userService.existUserAccount(userAccount);
        if(exist != null){
            return new Result(StatusCode.error,"账号存在,添加失败",null);
        }
        Boolean addUser = userService.addUser(userAccount,userName,password,age,gender);
        if(addUser){
            return new Result(StatusCode.success,"添加用户成功",null);
        }
        return new Result(StatusCode.error,"添加失败",null);
    }

    //用户列表
    @RequestMapping("/userList")
    public String userList(Model model){
        List<User> userList = userService.userList();
        model.addAttribute("users",userList);
        return "userList";
    }


    //修改用户信息
    @ResponseBody
    @RequestMapping("/user/changeInfo")
    public Result userChange(String userAccount, String userName, String password,Integer age,String gender){

        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if(userId==null || userId==0){
            return new Result(StatusCode.Not_login,"账号失效,请重新登录",null);
        }
        int changUserInfo = userService.changInfoByAccount(userAccount,userName,password,age,gender);
        if(changUserInfo !=0){
            return new Result(StatusCode.success,"修改成功",changUserInfo);
        }
        return new Result(StatusCode.error,"修改失败",null);

    }

    //删除用户
    @ResponseBody
    @RequestMapping("/deleteBtn")
    public Result deleteBtn(Integer userId){
        Boolean deleteUser = userService.deleteUserById(userId);
        if(deleteUser){
            return new Result(StatusCode.success,"删除成功",null);
        }
        return new Result(StatusCode.error,"删除成功",null);
    }
}
