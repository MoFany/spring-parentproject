package com.mofany.service.impl;

import com.mofany.entity.Student;
import com.mofany.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mofany.service.StudentService;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/1/4
 * @description StudentServiceImpl
 */
@Service
public class StudentServiceImpl implements StudentService {

    private StudentMapper studentMapper;

    /**
     * 构造器注入，且是改bean必须存在
     * */
    @Autowired(required = true)
    private StudentServiceImpl( StudentMapper studentMapper){
        this.studentMapper=studentMapper;
    }

    /**
     * 增
     *
     * @param student 要添加的学生
     */
    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    /**
     * 删
     *
     * @param name 要删除的学生姓名
     */
    @Override
    public int deleteByName(String name) {
        return studentMapper.deleteByName(name);
    }

    /**
     * 按id删除
     *
     * @param id 要删除的学生的id
     */
    @Override
    public int deleteById(int id) {
        return studentMapper.deleteById(id);
    }

    /**
     * 改
     *
     * @param student 要修改的学生
     */
    @Override
    public int updateById(Student student) {
        return studentMapper.updateById(student);
    }

    /**
     * 查
     *
     * @param id 按id查
     */
    @Override
    public Student selectById(int id) {
        return studentMapper.selectById(id);
    }

    /**
     * 查
     *
     * @param name 按姓名查
     */
    @Override
    public List<Student> selectByName(String name) {
        return studentMapper.selectByName(name);
    }

    /**
     * 按名称id
     *
     * @param name 要查的学生的姓名
     */
    @Override
    public List<Integer> selectIdByName(String name) {
        return studentMapper.selectIdByName(name);
    }
}
