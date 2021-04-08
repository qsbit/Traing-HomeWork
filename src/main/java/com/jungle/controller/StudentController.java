package com.jungle.controller;

import com.jungle.common.Result;
import com.jungle.entity.Student;
import com.jungle.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    @Autowired //注入
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("/findAllStudent")
    public Result finAllStudent(){
        List<Student> student = studentService.findAllStudent();
        return Result.setSucceed(student);
    }
}
