package com.mofany.mapper;

import com.mofany.entity.Student;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/1/25
 * @description StudentMapper
 */
public interface StudentMapper {
    /**
     * 增
     * */
    int insertByStudent(Student student);

    /**
     * 删
     * */
    int deleteById(int id);

    /**
     * 查
     * */
    List<Student> selectByName(String name);

    /**
     * 改
     * */
    int updateById(Student student);
}
