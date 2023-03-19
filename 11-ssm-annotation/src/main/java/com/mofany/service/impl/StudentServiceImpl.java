package com.mofany.service.impl;

import com.mofany.entity.Student;
import com.mofany.mapper.StudentMapper;
import com.mofany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/1/25
 * @description StudentServiceImpl
 */
@Service
public class StudentServiceImpl implements StudentService {

    private StudentMapper studentMapper;
    /**
     * 构造器注入
     * */
    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper){
        this.studentMapper=studentMapper;
    }

    /**
     * 增
     *
     * @param student
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = java.lang.RuntimeException.class)
    @Override
    public int insertByStudent(Student student) {
        return studentMapper.insertByStudent(student);
    }

    /**
     * 删
     *
     * @param id
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = java.lang.RuntimeException.class)
    public int deleteById(int id) {
        return studentMapper.deleteById(id);
    }

    /**
     * 查
     *
     * @param name
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = java.lang.RuntimeException.class)
    @Override
    public List<Student> selectByName(String name) {
        return studentMapper.selectByName(name);
    }

    /**
     * 改
     *
     * @param student
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = java.lang.RuntimeException.class)
    @Override
    public int updateById(Student student) {
        return studentMapper.updateById(student);
    }
}
