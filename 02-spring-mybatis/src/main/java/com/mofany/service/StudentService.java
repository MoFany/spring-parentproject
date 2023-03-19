package com.mofany.service;

import com.mofany.entity.Student;

/**
 * @author MoFany-J
 * @date 2022/12/30
 * @description StudentService
 */
public interface StudentService {
    /**
     * 增
     * @param student
     * */
    int insert(Student student);

    /**
     * 按名字删
     * @param name
     * */
    int deleteByName(String name);

    /**
     * 按名字修改
     * @param student
     * */
    int updateById(Student student);

    /**
     * 按name查
     * @param name
     * */
    Student selectByName(String name);
}
