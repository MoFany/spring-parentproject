package com.mofany.service.impl;

import com.mofany.entity.Teacher;
import com.mofany.mapper.TeacherMapper;
import com.mofany.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
     * 构造器注入,bean实例必须存在
     * */
    @Autowired
    private TeacherServiceImpl(TeacherMapper teacherMapper){
        this.teacherMapper=teacherMapper;
    }

    /**
     * 新增
     *
     * @param teacher 新增的教师
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor =java.lang.RuntimeException.class )
    @Override
    public int insertTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
    }

    /**
     * 按姓名查
     *
     * @param name 由于有同名教师则返回值为集合
     */
    @Override
    public List<Teacher> selectByName(String name) {
        return teacherMapper.selectByName(name);
    }
}
