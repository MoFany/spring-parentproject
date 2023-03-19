package com.mofany.controller;

import com.mofany.entity.Student;
import com.mofany.entity.Teacher;
import com.mofany.service.StudentService;
import com.mofany.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description MyController 自定义前端请求控制器
 */
@RestController
@RequestMapping(value = "shcool")
public class MyController {

    private StudentService studentService;
    private TeacherService teacherService;

    /**
     * 构造器注入
     * */
    @Autowired
    private MyController(StudentService studentService,TeacherService teacherService){
        this.studentService=studentService;
        this.teacherService=teacherService;
    }

    /**
     * 学生接口为：student/{name}
     * */
    @GetMapping(value = "student/{name}")
    @ResponseBody
    public Map<String,Object> studentRequestHandler(@PathVariable("name") String name)  {
        Map<String,Object> map=new HashMap<>();
        List<Student> studentList=studentService.selectByName(name);
        studentList.forEach((student)->{
            map.put("id",student.getId());
            map.put("name",student.getName());
            map.put("sex",student.getSex());
            map.put("age",student.getAge());
        });
        return map;
    }

    /**
     * 老师接口为：teacher/{name}
     * */
    @GetMapping(value = "teacher/{name}")
    @ResponseBody
    public Map<String,Object> teacherRequestHandler(@PathVariable("name") String name)  {
        Map<String,Object> map=new HashMap<>();
        List<Teacher> teacherList=teacherService.selectByName(name);
        teacherList.forEach((teacher)->{
            map.put("jobnum",teacher.getJobNum());
            map.put("name",teacher.getName());
            map.put("sex",teacher.getSex());
            map.put("subject",teacher.getSubject());
        });
        return map;
    }
}
