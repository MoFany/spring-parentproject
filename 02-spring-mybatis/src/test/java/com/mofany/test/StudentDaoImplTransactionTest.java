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
 * @description StudentDaoImplTransactionTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-transaction-aop.xml"})
public class StudentDaoImplTransactionTest {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private Student student;

    /**
     * 事务操作：按ids查询
     * */
    @Test
    public void test1(){
        studentDao.selectByIds(1000,200,300).stream().forEach(System.out::println);
    }

    /**
     * 事务操作：按id查询
     * */
    @Test
    public void test2(){
        System.out.println(studentDao.selectByName("赫拉"));
    }

    /**
     * 事务操作：插入一条记录
     * */
    @Test
    public void test3(){
        student.setId(null);
        student.setName("宋二娘");
        student.setSex("女");
        student.setAge((short) 22);
        System.out.println(studentDao.insert(student)==1?"插入成功":"插入失败");
    }

    /**
     * 事务操作：按name删除
     * */
    @Test
    public void test4(){
        System.out.println(studentDao.deleteByName("送二娘")==1?"删除成功":"删除失败");
    }

    /**
     * 事务操作：按id修改指定student的信息
     * */
    @Test
    public void test5(){
        student.setName("赫拉");
        student.setSex("女");
        student.setAge((short)21);
        System.out.println(studentDao.updateById(200,student));
    }
}
