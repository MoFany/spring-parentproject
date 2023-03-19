package com.mofany.service.impl;

import com.mofany.entity.Student;
import com.mofany.mapper.StudentMapper;
import com.mofany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MoFany-J
 * @date 2022/12/30
 * @description StudentServiceImpl
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

//    public StudentServiceImpl(StudentMapper studentMapper) {
//        this.studentMapper = studentMapper;
//    }

    /**
     * 增
     *
     * @param student
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    /**
     * 按名字删
     *
     * @param name
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public int deleteByName(String name) {
        return studentMapper.deleteByName(name);
    }

    /**
     * 按名字修改
     *
     * @param student
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public int updateById(Student student) {
        return studentMapper.updateById(student);
    }

    /**
     * 按name查
     *
     * @param name
     */
    @Override
    public Student selectByName(String name) {
        return studentMapper.selectByName(name);
    }
}
