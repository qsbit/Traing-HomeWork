package com.jungle.service.impl;

import com.jungle.entity.Teacher;
import com.jungle.repository.TeacherRepository;
import com.jungle.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher insert() {
        Teacher teacher = new Teacher();
        teacher.setTeacherAge(22);
        teacher.setTeacherName("李老师");
        teacher.setTeachTime(new Date());
        teacher.setTeacherAddress("河南");
        Teacher save = teacherRepository.save(teacher); //save方法也是update方法 id存在 修改  id不存在 插入
        return save;
    }

    @Override
    public Teacher findById(Integer id) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacherRepository.findById(id);
        return teacher;
    }

    @Override
    public Teacher findById_2(Integer id) {
        return teacherRepository.findTeacherById(id);
    }

    @Override
    public Teacher deleteById() {
        teacherRepository.deleteById(1);
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Page<Teacher> findAllByPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return teacherRepository.findAll(pageable);
    }

    @Override
    public List<Teacher> findByTeacherAge(Integer age) {
        return teacherRepository.findTeacherByTeacherAge(age);
    }

    @Override
    public List<Teacher> findByTeacherNameLike(String teacherName) {
        return teacherRepository.findTeacherByTeacherNameLike("%"+teacherName+"%");
    }

    @Override
    public List<Teacher> findTeacherByIdBetween(Integer start, Integer end) {
        return teacherRepository.findTeacherByIdBetween(start,end);
    }

    @Override
    public List<Teacher> findByAddress(String teacherAddress,Integer teacherAge) {
        return teacherRepository.findByAddress(teacherAddress,teacherAge);
    }

    @Override
    public int updateTeacherById(String teacherName, Integer id) {
        int i = teacherRepository.updateTeacherById(teacherName,id);
        return i;
    }

    @Override
    public int deleteTeacherById(Integer id) {
        int i = teacherRepository.deleteTeacherById(id);
        return i;
    }

    @Override
    public int updateTeacherById_Teacher(Teacher teacher) {
        return teacherRepository.updateTeacherById_Teacher(teacher);
    }

    @Override
    public int updateTeacherById_Teacher_4(Teacher teacher) {
        return teacherRepository.updateTeacherById_Teacher_4(teacher);
    }

}
