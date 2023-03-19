package com.mofany.dao;

import com.mofany.entity.Student;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2022/12/29
 * @description StudentDao
 */
public interface StudentDao {
    /**
     * 按ids查询多个学生
     * @param ids id数组
     * */
    List<Student> selectByIds(int...ids);

    /**
     * 按name查询
     * @param name 要查询的名字
     * */
    Student selectByName(String name);

    /**
     * 插入
     * @param student 插入的学生
     * */
    int insert(Student student);

    /**
     * 按指定的名字删除
     * @param name 要删除记录的姓名
     * */
    int deleteByName(String name);

    /**
     * 按id修改指定信息
     * @param id 要修改信息的id
     * @param student 新的值
     * */
    int updateById(int id,Student student);
}
