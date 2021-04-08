package com.jungle.service;

import com.jungle.entity.Teacher;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TeacherService {
    // 增加
    Teacher insert();

    /**
     * 方式一：根据id查询
     * @return
     */
    Teacher findById(Integer id);

    /**
     * 方式二：根据id查询
     * @return
     */
    Teacher findById_2(Integer id);

    //根据id删除
    Teacher deleteById();
    //查询所有
    List<Teacher> findAll();
    //分页查询
    Page<Teacher> findAllByPage(Integer page, Integer size);

    List<Teacher> findByTeacherAge(Integer age);

    /**
     * 模糊查询
     * @param teacherName
     * @return
     */
    List<Teacher> findByTeacherNameLike(String teacherName);

    /**
     * between查询
     */
    List<Teacher> findTeacherByIdBetween(Integer start, Integer end);

    /**
     * 方式三：根据地址查询
     */
    List<Teacher> findByAddress(String teacherAddress,Integer teacherAge);

    /**
     * 修改老师信息
     */
    int updateTeacherById(String teacherName, Integer id);

    /**
     * 删除老师信息
     */
    int deleteTeacherById(Integer id);

    /**
     * 根据对象修改属性
     */
    int updateTeacherById_Teacher(Teacher teacher);

    /**
     * 方式四
     * 根据对象修改属性
     */
    int updateTeacherById_Teacher_4(Teacher teacher);

}
