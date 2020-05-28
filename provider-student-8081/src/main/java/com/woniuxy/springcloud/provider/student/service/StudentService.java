package com.woniuxy.springcloud.provider.student.service;

import com.woniuxy.springcloud.common.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    Student getStudentBySid(Integer sid);
    List<Student> getAllStudents();
}
