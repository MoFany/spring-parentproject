package com.mofany.controller;

import com.mofany.entity.Teacher;
import com.mofany.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description MyController
 */
@Controller
@RequestMapping(value = "teacher")
public class MyController {

    private TeacherService teacherService;

    /**
     * 构造器注入
     * */
    @Autowired(required = true)
    private MyController(TeacherService teacherService){
        this.teacherService=teacherService;
    }

    @GetMapping("{name}")
    public String selectTeacher(@PathVariable("name") String name,Model model){
        List<Teacher> teacherList=teacherService.selectByName(name);
        model.addAttribute("teacherList",teacherList);
        return "teacher";
    }
}
