package com.jungle.service;

import com.jungle.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    List<Student> findAllStudent();
}
