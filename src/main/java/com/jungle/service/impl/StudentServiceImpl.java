package com.jungle.service.impl;

import com.jungle.entity.Student;
import com.jungle.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> findAllStudent(){
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student(i,"student"+i,i);
            studentList.add(student);
        }
        return studentList;
    }
}
