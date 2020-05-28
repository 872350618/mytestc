package com.woniuxy.springcloud.consumer.student.controller;

import com.woniuxy.springcloud.common.entity.ResponseResult;
import com.woniuxy.springcloud.common.entity.Student;
import com.woniuxy.springcloud.consumer.student.feigncient.StudentFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//设置统一的默认降级方法
//@DefaultProperties(defaultFallback = "consumerstudentfallback")
//@CrossOrigin
@RestController
@RequestMapping("/consumerstudent")
public class ConsumerStudentController {

    //7071调用8081,使用RestTemplate调用
//    @Autowired
//    RestTemplate restTemplate;

    //通过注册中心调用服务:resttemplate+注册中心
//    @Autowired
//    DiscoveryClient discoveryClient;

//    private String getUrl(){
//        //通过注册中心服务的名称获取服务信息
//        List<ServiceInstance> instances =
//                discoveryClient.getInstances("provider-student");
//        ServiceInstance instance = instances.get(0);
//        return  "http://"+instance.getHost()+":"+instance.getPort()+"/student/";
//    }


//    private String getUrl(){
//        //ribbon直接使用服务名
//        return "http://provider-student/student/";
//    }

    @Autowired
    StudentFeignClient studentFeignClient;

    //@HystrixCommand
    @RequestMapping("/ok")
    public ResponseResult ok(){
        return  studentFeignClient.ok();
    }

    //@HystrixCommand
    //配置降级方法
    //@HystrixCommand(fallbackMethod = "timeoutfallback")
    @RequestMapping("/timeout")
    public ResponseResult timeout(){
        return  studentFeignClient.timeout();
    }



//    public ResponseResult consumerstudentfallback(){
//        return new ResponseResult(200,"consumerstudentfallback");
//    }

    @PostMapping("/")
    public ResponseResult addStudent(Student student){
        return studentFeignClient.addStudent(student);
    }

    @GetMapping("/{sid}")
    public ResponseResult<Student> getStudentBySid(@PathVariable("sid") Integer sid){
        return studentFeignClient.getStudentBySid(sid);
    }

    @GetMapping("/")
    public ResponseResult<List<Student>> getAllStudents(){
        return studentFeignClient.getAllStudents();
    }
}
