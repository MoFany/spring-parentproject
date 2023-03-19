package com.mofany.service.impl;

import com.mofany.entity.Teacher;
import com.mofany.mapper.TeacherMapper;
import com.mofany.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description TeacherServiceImpl
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherMapper teacherMapper;

    /**
     * 构造器注入，且该bean必须存在
     * */
    @Autowired(required = true)
    private TeacherServiceImpl(TeacherMapper teacherMapper){
        this.teacherMapper=teacherMapper;
    }

    /**
     * 增
     *
     * @param teacher
     */
    @Override
    public int insertTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
    }

    /**
     * 按姓名（姓名可以重名）查ids
     *
     * @param name
     */
    @Override
    public List<Integer> selectIdsByName(String name) {
        return teacherMapper.selectIdsByName(name);
    }

    /**
     * 按姓名查
     *
     * @param name
     */
    @Override
    public List<Teacher> selectByName(String name) {
        return teacherMapper.selectByName(name);
    }

    /**
     * 删
     *
     * @param id
     */
    @Override
    public int deleteById(int id) {
        return teacherMapper.deleteById(id);
    }
}
