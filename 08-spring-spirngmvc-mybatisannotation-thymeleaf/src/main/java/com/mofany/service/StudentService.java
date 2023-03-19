package com.mofany.service;

import com.mofany.entity.Student;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description StudentService
 */
public interface StudentService {
    /**
     * 新增
     *
     * @param student 新增的学生
     * */
    int insertStudent(Student student);

    /**
     * 按姓名查
     *
     * @param name 由于有同名学生则返回值为集合
     * */
    List<Student> selectByName(String name);
}
