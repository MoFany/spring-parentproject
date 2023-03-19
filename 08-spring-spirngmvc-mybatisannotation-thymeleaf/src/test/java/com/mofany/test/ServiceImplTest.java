package com.mofany.test;

import com.mofany.config.SpringBeansConfig;
import com.mofany.entity.Student;
import com.mofany.entity.Teacher;
import com.mofany.service.StudentService;
import com.mofany.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description ServiceImplTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringBeansConfig.class})
@WebAppConfiguration("src/main/resources")
public class ServiceImplTest {
    @Autowired
    private Student student;
    @Autowired
    private Teacher teacher;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @Test
    public void test1(){
        studentService.selectByName("海波东").stream().forEach(System.out::println);
    }

    @Test
    public void test2(){
        student.setId(null);
        student.setName("砝码");
        student.setSex("男");
        student.setAge((short)66);
        studentService.insertStudent(student);
    }

    @Test
    public void test3(){
        teacherService.selectByName("默凡语").stream().forEach(System.out::println);
    }

    @Test
    public void test4(){
        teacher.setJobNum(7);
        teacher.setName("承太郎");
        teacher.setSex("男");
        teacher.setSubject("大学日语");
        teacherService.insertTeacher(teacher);
    }
}
