package com.woniuxy.springcloud.provider.student.mapper;

import com.woniuxy.springcloud.common.entity.Student;

import java.util.List;

public interface StudentMapper {
    void insertStudent(Student Student);
    Student selectStudentBySid(Integer sid);
    List<Student> selectAllStudents();
}
