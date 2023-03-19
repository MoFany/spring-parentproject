package com.mofany.test;

import com.mofany.config.SpringBeansConfig;
import com.mofany.entity.Student;
import com.mofany.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author MoFany-J
 * @date 2023/1/25
 * @description StudentServiceImplTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringBeansConfig.class})
@WebAppConfiguration("src/main/resources")
public class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;
    /**
     * 增
     * */
    @Test
    public void test1(){
        Student student=new Student();
        student.setId(null);
        student.setName("莉莉安");
        student.setSex("女");
        student.setAge((short)23);
    }

    /**
     * 删
     * */
    @Test
    public void test2(){
        int id=123;
        studentService.deleteById(id);
    }

    /**
     * 查
     * */
    @Test
    public void test3(){
        studentService.selectByName("美杜莎").stream().forEach(System.out::println);
    }

    /**
     * 改
     * */
    @Test
    public void test4(){
        Student student=new Student();
        student.setId(null);
        student.setName("阿波罗");
        student.setSex("男");
        student.setAge((short)22);
        studentService.updateById(student);
    }
}
