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
 * @date 2022/12/29
 * @description SpringIntegrateMyBatisTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class SpringIntegrateMyBatisTest {
    @Autowired
    private StudentService studentService;
    @Autowired
    private Student student;

    /**
     * 按id修改信息
     * */
    @Test
    public void test1(){
        student.setId(100);
        student.setName("窦娥");
        student.setSex("女");
        student.setAge((short)21);
        System.out.println(studentService.updateById(student));
    }

    /**
     * 新增一条信息
     * */
    @Test
    public void test2(){
        student.setId(null);
        student.setName("丘比特");
        student.setSex("男");
        student.setAge((short)16);
        System.out.println(studentService.insert(student));
    }

    /**
     * 按名字查询对应信息
     * */
    @Test
    public void test3(){
        System.out.println(studentService.selectByName("丘比特"));
        System.out.println(studentService.selectByName("窦娥"));
    }

    /**
     * 按名字删除对应信息
     * */
    @Test
    public void test4(){
        System.out.println(studentService.deleteByName("丘比特"));
    }
}
