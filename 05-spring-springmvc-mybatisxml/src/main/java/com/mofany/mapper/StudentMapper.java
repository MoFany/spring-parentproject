package com.mofany.mapper;

import com.mofany.entity.Student;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/1/4
 * @description StudentMapper
 */
public interface StudentMapper {
    /**
     * 增
     * @param student 要添加的学生
     * */
    int insertStudent(Student student);

    /**
     * 删
     * @param name 要删除的学生姓名
     * */
    int deleteByName(String name);

    /**
     * 按id删除
     * @param id 要删除的学生的id
     * */
    int deleteById(int id);

    /**
     * 改
     * @param student 要修改的学生
     * */
    int updateById(Student student);

    /**
     * 查
     * @param id 按id查
     * */
    Student selectById(int id);

    /**
     * 查
     * @param name 按姓名查
     * */
    List<Student> selectByName(String name);

    /**
     * 按名称id
     * @param name 要查的学生的姓名
     * */
    List<Integer> selectIdByName(String name);
}
