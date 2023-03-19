package com.mofany.dao.impl;

import com.mofany.dao.StudentDao;
import com.mofany.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author MoFany-J
 * @date 2022/12/29
 * @description StudentDaoImpl
 */
@Repository
public class StudentDaoImpl implements StudentDao {
    /**
     * spring自带的jdbc------------重点注解的参数值
     * @Autowired(required=true)：默认按类型注入找不见就按名称注入，表示注入的时候，该bean必须存在，否则就会注入失败
     * @Autowired(required=false)：表示忽略当前要注入的bean，如果有直接注入，没有跳过，不会报错
     * */
    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;

    /**
     * 按ids查询多个学生
     *
     * @param ids id数组
     */
    @Override
    public List<Student> selectByIds(int... ids) {
        String param= Arrays.toString(ids).replace('[','(').replace(']',')');
        List<Student> studentList=null;
        StringBuilder sql = new StringBuilder("select * from student where id in");
        sql.append(param);
        studentList=jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Student.class));
        return studentList;
    }

    /**
     * 按name查询
     *
     * @param name
     */
    @Override
    public Student selectByName(String name) {
        Student student=null;
        try {
            student=jdbcTemplate.queryForObject("select * from student where name=?",
                    new BeanPropertyRowMapper<>(Student.class),name);
        }catch (EmptyResultDataAccessException e){
            System.out.println("未查询到指定数据！"+e.getMessage());
        }
        return student;
    }

    /**
     * 插入
     *
     * @param student 要插入的学生
     * */
    @Override
    public int insert(Student student) {
        int result=0;
        result=jdbcTemplate.update("insert into student values (?,?,?,?)",
                student.getId(),student.getName(),student.getSex(),student.getAge());
        return result;
    }

    /**
     * 按指定的名字删除
     *
     * @param name
     */
    @Override
    public int deleteByName(String name) {
        int result=0;
        result=jdbcTemplate.update("delete from student where name=?",name);
        return result;
    }

    /**
     * 按id修改指定信息
     *
     * @param id      要修改信息的id
     * @param student 新的值
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor =RuntimeException.class )
    @Override
    public int updateById(int id, Student student) {
        int result=0;
        result=jdbcTemplate.update("update student set name=?,sex=?,age=? where id=?",
                student.getName(),student.getSex(),student.getAge(),id);
        return result;
    }


}
