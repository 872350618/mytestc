package com.woniuxy.springcloud.provider.student.mapper;

import com.woniuxy.springcloud.common.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentMapperTest {

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testinsertStudent(){
        studentMapper.insertStudent(new Student(1,"abc",11));
    }
}
