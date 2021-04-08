package com.jungle.mapper;

import com.jungle.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

//数据库进行数据持久化操作，他的方法语句是直接针对数据库操作的
@Mapper
public interface UserMapper {

    /**
     * userAccount+password
     */
    User findUserByUserAccountAndPassword(String userAccount, String password);

    int findUserExitOrNot(String userAccount, String password);

    User findUserById(Integer id);

    List<Map<String,Object>> userGenderNum();

    List<Map<String,Object>> userAgeNum();

    int changInfoByAccount(String userAccount, String userName, String password,Integer age,String gender);

    Boolean addUser(String userAccount,String userName,String password,Integer age,String gender);

    List<User> userList();

    Boolean deleteUserById(Integer id);

    User existUserAccount(String userAccount);
}
