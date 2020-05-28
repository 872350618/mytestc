package com.woniuxy.springcloud.consumer.student.feigncient;

import com.woniuxy.springcloud.common.entity.ResponseResult;
import com.woniuxy.springcloud.common.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@RequestMapping("/studentfallback")
public class StudentFeignClientFallback implements StudentFeignClient {
    @Override
    public ResponseResult ok() {
        return new ResponseResult(200,"okfallback");
    }

    @Override
    public ResponseResult timeout() {
        return new ResponseResult(200,"timeoutfallback");
    }

    @Override
    public ResponseResult addStudent(Student student) {
        return null;
    }

    @Override
    public ResponseResult<Student> getStudentBySid(Integer sid) {
        return null;
    }

    @Override
    public ResponseResult<List<Student>> getAllStudents() {
        return null;
    }
}
