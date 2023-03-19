package com.mofany.dao.impl;

import com.mofany.dao.TeacherDao;
import com.mofany.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author MoFany-J
 * @date 2022/12/26
 * @description TeacherDaoImpl
 */
@Repository("teacherDaoImpl")
public class TeacherDaoImpl implements TeacherDao {

    private Teacher teacher;
    /**
     * 构造器注入
     * */
    @Autowired
    private TeacherDaoImpl(Teacher teacher){
        this.teacher=teacher;
    }

    /**
     * 增
     */
    @Override
    public void testInsert() {
        teacher.setJobnum(1);
        teacher.setName("李老师");
        teacher.setSex("女");
        teacher.setSubject("大学舞蹈");
        System.out.println("test insert:"+teacher);
    }

    /**
     * 删
     */
    @Override
    public void testDelete() {
        teacher=new Teacher();
        System.out.println("test delete:"+teacher);
    }

    /**
     * 改
     */
    @Override
    public void testUpdate() {
        teacher.setJobnum(2);
        teacher.setName("王老师");
        teacher.setSex("男");
        teacher.setSubject("大学化学");
        System.out.println("test update:"+teacher);
    }

    /**
     * 查
     */
    @Override
    public void testSelect() {
        System.out.println("test select:"+teacher);
    }
}
