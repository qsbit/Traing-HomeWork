package com.jungle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * jpa 生成表
 * mybatis 操作表
 */
// 用于存放我们的实体类，与数据库中的属性值基本保持一致
@Entity
@Table(name = "user")
@AllArgsConstructor  //添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor   //为类提供一个无参的构造方法。
 //为类提供读写功能，从而不用写get、set方法
@ToString  //
public class User {
    @Id  //设置id为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //指定自增
    private Integer id;

    private String userAccount;

    private String userName;

    private String password;

    private Integer age;

    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
