package com.mofany.service;

import com.mofany.entity.Teacher;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description TeacherService
 */
public interface TeacherService {
    /**
     * 增
     * */
    int insertTeacher(Teacher teacher);

    /**
     * 按姓名（姓名可以重名）查ids
     * */
    List<Integer> selectIdsByName(String name);

    /**
     * 按姓名查
     * */
    List<Teacher> selectByName(String name);

    /**
     * 删
     * */
    int deleteById(int id);
}
