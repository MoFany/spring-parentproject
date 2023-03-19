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
 * @date 2023/1/5
 * @description StudentServiceImpl
 */
@Service
public class StudentServiceImpl implements StudentService {
    private StudentMapper studentMapper;
    /**
     * 构造器注入,bean实例必须存在
     * */
    @Autowired(required = true)
    private StudentServiceImpl(StudentMapper studentMapper){
        this.studentMapper=studentMapper;
    }

    /**
     * 新增
     *
     * @param student 新增的学生
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor =java.lang.RuntimeException.class )
    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    /**
     * 按姓名查
     *
     * @param name 由于有同名学生则返回值为集合
     */
    @Override
    public List<Student> selectByName(String name) {
        return studentMapper.selectByName(name);
    }
}
