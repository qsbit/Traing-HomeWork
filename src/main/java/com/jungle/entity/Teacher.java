package com.jungle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

// Map - 数据库表
// 实体 - 数据库表
@Entity
@Table(name = "hsd_teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher {
    @Id  //设置id为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //指定自增
    private Integer id;

    private String teacherName;

    private Integer teacherAge;

    private String teacherAddress;

    private String ImageUrl;

    @Transient  //忽略持久化
    private String school;

    @Column(name = "hsd_teach_time")
    private Date teachTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getTeachTime() {
        return teachTime;
    }

    public void setTeachTime(Date teachTime) {
        this.teachTime = teachTime;
    }
}
