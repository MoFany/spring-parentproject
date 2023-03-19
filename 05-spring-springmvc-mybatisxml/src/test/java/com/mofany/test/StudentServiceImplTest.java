package com.mofany.test;

import com.mofany.entity.Student;
import com.mofany.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author MoFany-J
 * @date 2023/1/4
 * @description StudentServiceImplTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml"})
public class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;
    @Autowired
    private Student student;

    /**
     * 增
     * */
    @Test
    public void test1(){
        student.setId(null);
        student.setName("汤米谢尔比");
        student.setSex("男");
        student.setAge((short)32);
        System.out.println(studentService.insertStudent(student));
    }

    /**
     * 查
     * */
    @Test
    public void test2(){
        System.out.println(studentService.selectByName("汤米谢尔比"));
        System.out.println(studentService.deleteByName("诸葛日照"));
    }

    /**
     * 按名称查询id
     * */
    @Test
    public void test3(){
        studentService.selectIdByName("汤米谢尔比").stream().forEach(System.out::println);
        studentService.selectIdByName("宋江").stream().forEach(System.out::println);
    }

    /**
     * 删
     * */
    @Test
    public void test4(){
        System.out.println(studentService.deleteByName("汤米谢尔比"));
        System.out.println(studentService.deleteByName("诸葛日照"));
    }

    /**
     * 先按姓名查，查询到的同名学生记录全删除
     * */
    @Test
    public void test5(){
        studentService.selectIdByName("汤米谢尔比").stream().forEach(studentService::deleteById);
    }

    /**
     * 改
     * */
    @Test
    public void test6(){
        student.setId(1000);
        student.setName("诸葛日照");
        student.setSex("男");
        student.setAge((short)21);
        System.out.println(studentService.updateById(student));
    }
}
