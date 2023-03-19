package com.mofany.test;

import com.mofany.dao.StudentDao;
import com.mofany.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author MoFany-J
 * @date 2022/12/29
 * @description StudentDaoImplTest 基础CRUD操作测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-jdbctemplate.xml"})
public class StudentDaoImplTest {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private Student student;

    /**
     * 按ids批量查询
     * */
    @Test
    public void test1(){
        int[] ids={200,300,100};
        studentDao.selectByIds(ids).stream().forEach(System.out::println);
    }

    /**
     * 插入新记录
     * */
    @Test
    public void test2(){
        student.setId(null);
        student.setName("武松");
        student.setSex("男");
        student.setAge(Short.valueOf("23"));
        System.out.println(studentDao.insert(student)==1?"插入成功":"插入失败");
    }

    /**
     * 按name查询
     * */
    @Test
    public void test3(){
        System.out.println(studentDao.selectByName("武松"));
    }

    /**
     * 按name删除
     * */
    @Test
    public void test4(){
        System.out.println(studentDao.deleteByName("武松")==1?"删除成功":"删除失败");
    }
}
