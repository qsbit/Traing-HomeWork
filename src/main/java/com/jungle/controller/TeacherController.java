package com.jungle.controller;

import com.jungle.common.Result;
import com.jungle.common.StatusCode;
import com.jungle.entity.Teacher;
import com.jungle.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 增加信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/jpa_insert")
    public Result insert(){
        Teacher teacher = teacherService.insert();
        return new Result(StatusCode.success,"增加成功",teacher);
    }

    /**
     * 方式一：根据id查找信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/jpa_finById/{id}")
    public Result findById(@PathVariable Integer id){
        Teacher teacher = teacherService.findById(id);
        return new Result(StatusCode.success,"根据id查询",teacher);
    }

    /**
     * 方式二：根据id查找信息
     */
    @ResponseBody
    @RequestMapping("/jpa_finById2/{id}")
    public Result findById2(@PathVariable Integer id){
        Teacher teacher = teacherService.findById_2(id);
        return new Result(StatusCode.success,"根据id查询",teacher);
    }

    /**
     * 根据id删除信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/jpa_deleteById")
    public Result deleteById(){
        Teacher teacher = teacherService.deleteById();
        return new Result(StatusCode.success,"根据id删除",teacher);
    }

    /**
     * 查询所有
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/jpa_findAll")
    public Result finAll(){
        List<Teacher> teacher = teacherService.findAll();
        return new Result(StatusCode.success,"查询所有",teacher);
    }

    /**
     * 查询所有
     * @return
     */
    @ResponseBody
    @RequestMapping("/jpa_findAllByPage/{page}/{size}")
    public Result findAllByPage(@PathVariable Integer page,@PathVariable Integer size){
        Page<Teacher> teacher = teacherService.findAllByPage(page, size);
        return new Result(StatusCode.success,"分页查询",teacher);
    }

    /**
     * 根据age查询
     */
    @ResponseBody
    @RequestMapping("/jpa_findByTeacherAge/{age}")
    public Result findByTeacherAge(@PathVariable Integer age){
        List<Teacher> teacher = teacherService.findByTeacherAge(age);
        return new Result(StatusCode.success,"根据年龄查询",teacher);
    }

    /**
     * 模糊查询
     */
    @ResponseBody
    @RequestMapping("/jpa_findByTeacherNameLike/{teacherName}")
    public Result findByTeacherNameLike(@PathVariable String teacherName){
        List<Teacher> teacher = teacherService.findByTeacherNameLike(teacherName);
        return new Result(StatusCode.success,"根据姓名模糊查询",teacher);
    }

    /**
     * 区间查询
     */
    @ResponseBody
    @RequestMapping("/jpa_findTeacherByIdBetween")
    public Result findTeacherByIdBetween( Integer start,  Integer end){
        List<Teacher> teacher = teacherService.findTeacherByIdBetween(start,end);
        return new Result(StatusCode.success,"根据id区间查询",teacher);
    }

    /**
     * 方式三
     * 根据地址查询
     */
    @ResponseBody
    @RequestMapping("/jpa_findByAddress")
    public Result findByAddress(String teacherAddress,Integer teacherAge){
        List<Teacher> teacher = teacherService.findByAddress(teacherAddress,teacherAge);
        return new Result(StatusCode.success,"根据地址和年龄查询",teacher);
    }

    /**
     * 根据id修改教师信息
     * @param teacherName
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/jpa_updateTeacherById")
    public Result updateTeacherById(String teacherName,Integer id){
        int i = teacherService.updateTeacherById(teacherName,id);
        return new Result(StatusCode.success,"方式三 修改",i);
    }

    /**
     * 根据id删除教师信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/jpa_deleteTeacherById")
    public Result deleteTeacherById(Integer id){
        int i = teacherService.deleteTeacherById(id);
        return new Result(StatusCode.success,"方式三 删除",i);
    }

    /**
     * 传入对象 修改
     * @param teacher
     * @return
     */
    @ResponseBody
    @RequestMapping("/jpa_updateTeacherById_Teacher")
    public Result updateTeacherById_Teacher(Teacher teacher){
        int i = teacherService.updateTeacherById_Teacher(teacher);
        return new Result(StatusCode.success,"方式三 根据对象更新",i);
    }

    @ResponseBody
    @RequestMapping("/jpa_updateTeacherById_Teacher_4")
    public Result updateTeacherById_Teacher_4(Teacher teacher){
        int i = teacherService.updateTeacherById_Teacher_4(teacher);
        return new Result(StatusCode.success,"方式三 根据对象更新",i);
    }


}
