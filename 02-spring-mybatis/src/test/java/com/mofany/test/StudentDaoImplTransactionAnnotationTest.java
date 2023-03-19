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
 * @description StudentDaoImplTransactionAnnotationTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-transaction-annotation.xml"})
public class StudentDaoImplTransactionAnnotationTest {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private Student student;

    /**
     * 事务操作：按id修改指定student的信息
     * */
    @Test
    public void test1(){
        student.setName("波塞冬");
        student.setSex("男");
        student.setAge((short)22);
        System.out.println(studentDao.updateById(99,student));
    }

    /**
     * 事务操作：按id查询
     * */
    @Test
    public void test2(){
        System.out.println(studentDao.selectByName("波塞冬"));
    }
}
