package com.woniuxy.springcloud.provider.student.service.impl;

import com.woniuxy.springcloud.common.entity.Student;
import com.woniuxy.springcloud.provider.student.mapper.StudentMapper;
import com.woniuxy.springcloud.provider.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public void addStudent(Student student) {
        studentMapper.insertStudent(student);
    }

    @Override
    public Student getStudentBySid(Integer sid) {
        return studentMapper.selectStudentBySid(sid);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectAllStudents();
    }
}
