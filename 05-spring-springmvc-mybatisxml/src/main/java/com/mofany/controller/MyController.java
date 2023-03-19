package com.mofany.controller;

import com.mofany.entity.Student;
import com.mofany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/1/4
 * @description MyController 自定义控制器
 */
@Controller
@RequestMapping("student")
public class MyController {
    @Autowired
    private StudentService studentService;


    @GetMapping(value = "{name}")
    public ModelAndView requestHandler(@PathVariable("name") String name){
        List<Student> studentList=studentService.selectByName(name);
        ModelAndView modelAndView=new ModelAndView("student");
        modelAndView.addObject("studentList",studentList);
        return modelAndView;
    }
}
