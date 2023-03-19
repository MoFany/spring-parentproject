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
     * 新增
     *
     * @param teacher 新增的教师
     * */
    int insertTeacher(Teacher teacher);

    /**
     * 按姓名查
     *
     * @param name 由于有同名教师则返回值为集合
     * */
    List<Teacher> selectByName(String name);
}
