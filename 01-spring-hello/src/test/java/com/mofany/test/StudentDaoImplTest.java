package com.mofany.test;

import com.mofany.dao.TeacherDao;
import com.mofany.dao.impl.StudentDaoImpl;
import com.mofany.entity.Student;
import com.mofany.entity.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MoFany-J
 * @date 2022/12/21
 * @description StudentDaoImplTest
 */
public class StudentDaoImplTest {

    /**
     * bean的基本作用域
     * */
    @Test
    public void test1(){
        //加载类路径下指定的xml文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-beans.xml");
        System.out.println("-----------------单例模式（复用同一对象）-------------------");
        //获取单例bean实例
        var obj1=applicationContext.getBean("student1", Student.class);
        System.out.println(obj1);
        obj1=applicationContext.getBean("student1", Student.class);
        System.out.println(obj1);
        obj1=applicationContext.getBean("student1", Student.class);
        System.out.println(obj1);
        System.out.println("-----------------原型模式（创建不同对象）-------------------");
        //获取原型bean实例
        var obj2=applicationContext.getBean("student2", Student.class);
        System.out.println(obj2);
        obj2=applicationContext.getBean("student2", Student.class);
        System.out.println(obj2);
        obj2=applicationContext.getBean("student2", Student.class);
        System.out.println(obj2);
        System.out.println("-----------------单例模式(默认)-------------------");
        var obj3=applicationContext.getBean("student3", Student.class);
        System.out.println(obj3);
    }

    /**
     * 手动依赖注入
     * */
    @Test
    public void test3(){
        //加载类路径下指定的xml文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-ioc.xml");
        //构造器的依赖注入
        var tea=applicationContext.getBean("teacher1", Teacher.class);
        System.out.println(tea);
        tea=applicationContext.getBean("teacher2", Teacher.class);
        System.out.println(tea);
        tea=applicationContext.getBean("teacher3", Teacher.class);
        System.out.println(tea);
        tea=applicationContext.getBean("teacher4", Teacher.class);
        System.out.println(tea);
        tea=applicationContext.getBean("teacher5", Teacher.class);
        System.out.println(tea);
        tea=applicationContext.getBean("teacher6", Teacher.class);
        System.out.println(tea);
    }

    /**
     * 自动依赖注入
     * */
    @Test
    public void test4(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-autowire.xml");
        //ByName：按名称自动注入
        System.out.println("-------------------ByName：按名称自动注入--------------------");
        var stu=applicationContext.getBean("studentDaoImpl1", StudentDaoImpl.class);
        System.out.println(stu);
        stu.print();
        //ByType：按类型自动注入
        System.out.println("-------------------ByType：按类型自动注入--------------------");
        stu=applicationContext.getBean("studentDaoImpl2", StudentDaoImpl.class);
        System.out.println(stu);
        stu.print();
        //ByConstruct：按构造器自动注入
        System.out.println("-------------------ByConstruct：按构造器自动注入--------------------");
        stu=applicationContext.getBean("studentDaoImpl3", StudentDaoImpl.class);
        System.out.println(stu);
        stu.print();
    }

    /**
     * Spring-AOP：默认的
     * */
    @Test
    public void test5(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-aop1.xml");
        //获取代理对象
        var obj1=applicationContext.getBean("teacherDao",TeacherDao.class);
        obj1.testInsert();
        obj1.testDelete();
        obj1.testUpdate();
        obj1.testSelect();
    }


    /**
     * Spring-AOP：默认的（带顾问）
     * */
    @Test
    public void test6(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-aop2.xml");
        //获取代理对象
        var obj1=applicationContext.getBean("teacherDao",TeacherDao.class);
        obj1.testInsert();
        obj1.testDelete();
        obj1.testUpdate();
        obj1.testSelect();
    }

    /**
     * Spring-AOP：第三方
     * */
    @Test
    public void test7(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-aspectj-aop1.xml");
        //获取代理对象
        var obj1=applicationContext.getBean("teacherDaoImpl", TeacherDao.class);
        obj1.testInsert();
        System.out.println("===============================");
        obj1.testDelete();
        System.out.println("===============================");
        obj1.testUpdate();
        System.out.println("===============================");
        obj1.testSelect();
    }
}
