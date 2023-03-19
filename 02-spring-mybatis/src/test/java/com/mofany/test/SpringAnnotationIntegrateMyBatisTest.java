package com.mofany.test;

import com.mofany.config.AnnotationConfig;
import com.mofany.entity.Student;
import com.mofany.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author MoFany-J
 * @date 2023/1/3
 * @description SpringAnnotationIntegrateMyBatisTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载配置类
 * */
@ContextConfiguration(classes = {AnnotationConfig.class})
public class SpringAnnotationIntegrateMyBatisTest {
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
        student.setName("海泽明");
        student.setSex("男");
        student.setAge((short)22);
        System.out.println(studentService.insert(student));
    }


    /**
     * 删
     * */
    @Test
    public void test2(){
        System.out.println(studentService.deleteByName("海泽明"));
    }

    /**
     * 改
     * */
    @Test
    public void test3(){
        student.setId(1000);
        student.setName("王路飞");
        student.setSex("男");
        student.setAge((short)23);
        System.out.println(studentService.updateById(student));
    }

    /**
     * 查
     * */
    @Test
    public void test4(){
        System.out.println(studentService.selectByName("海泽明"));
        System.out.println(studentService.selectByName("王路飞"));
    }
}
