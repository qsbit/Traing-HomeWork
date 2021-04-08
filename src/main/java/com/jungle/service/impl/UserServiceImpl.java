package com.jungle.service.impl;

import com.jungle.entity.User;
import com.jungle.mapper.UserMapper;
import com.jungle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//service的 impl 是把mapper和service进行整合的文件。
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUserAccountAndPassword(String userAccount, String password) {
        return userMapper.findUserByUserAccountAndPassword(userAccount,password);
    }

    @Override
    public int findUserExitOrNot(String userAccount, String password) {
        return userMapper.findUserExitOrNot(userAccount,password);
    }

    @Override
    public List<Map<String,Object>> userGenderNum() {
        List<Map<String,Object>> userGenderNum = userMapper.userGenderNum();
        return userGenderNum;
    }

    @Override
    public List<Map<String, Object>> userAgeNum() {
        List<Map<String,Object>> userAgeNum = userMapper.userAgeNum();
        return userAgeNum;
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public int changInfoByAccount(String userAccount, String userName, String password, Integer age, String gender) {
        return userMapper.changInfoByAccount(userAccount,userName,password,age,gender);
    }


    @Override
    public Boolean addUser(String userAccount,String userName,String password,Integer age,String gender) {
        return userMapper.addUser(userAccount,userName,password,age,gender);
    }

    @Override
    public List<User> userList() {
        List<User> userList = userMapper.userList();
        return userList;
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public User existUserAccount(String userAccount) {
        return userMapper.existUserAccount(userAccount);
    }


}
