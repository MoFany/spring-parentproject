package com.mofany.test;

import com.mofany.entity.Teacher;
import com.mofany.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description TeacherServiceImplTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml"})
public class TeacherServiceImplTest {
    @Autowired
    private Teacher teacher;
    @Autowired
    private TeacherService teacherService;

    @Test
    public void test1(){
        teacherService.selectByName("宋江").stream().forEach(System.out::println);
    }

    @Test
    public void test2(){
        teacher.setJobnum(6);
        teacher.setName("王明");
        teacher.setSex("男");
        teacher.setSubject("大学体育");
        System.out.println(teacherService.insertTeacher(teacher));
    }
}
