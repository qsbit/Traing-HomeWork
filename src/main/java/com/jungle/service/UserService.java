package com.jungle.service;

import com.jungle.entity.User;

import java.util.List;
import java.util.Map;
//service层 是针对 controller层的 controller，也就是针对我们使用者。

public interface UserService {
    // 登录时账号密码输入是否正确
    User findUserByUserAccountAndPassword(String userAccount, String password);

    // 根据id查询当前用户信息
    User findUserById(Integer id);

    //男女用户数量图表 返回的数据类型是 存储对象的数组
    List<Map<String,Object>> userGenderNum();

    //    用户年龄段统计表
    List<Map<String,Object>> userAgeNum();

    // 根据用户的账号修改个人信息 返回值为int类型 修改数据的条数
    int changInfoByAccount(String userAccount, String userName, String password,Integer age,String gender);

    // 添加用户前 判断该用户的账号是否存在
    User existUserAccount(String userAccount);

    // 添加用户
    Boolean addUser(String userAccount,String userName,String password,Integer age,String gender);

    // 所有用户列表
    List<User> userList();

    // 根据id值删除用户
    Boolean deleteUserById(Integer id);

    int findUserExitOrNot(String userAccount, String password);

}
