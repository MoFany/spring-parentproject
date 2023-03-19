package com.mofany.dao.impl;

import com.mofany.dao.StudentDao;
import com.mofany.entity.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author MoFany-J
 * @date 2022/12/26
 * @description StudentDaoImpl
 */
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDaoImpl implements StudentDao {
    /**
     * 给成员变量自动注入值，但需要提供setter方法
     * 1.ByName按名称注入就是以成员变量名为id名，
     *   从配置中寻找有没有id为student的bean实例（必须提供自动注入属性的setter方法）
     * 2.ByType按类型注入则是按照成员变量的类型Student为匹配条件，
     *   从配置中寻找Class为Student的bean实例（必须提供自动注入属性的setter方法，只能存在一个该类类型的bean实例否则抛异常）
     * 3.construct按构造器注入则是按照成员变量的构造器进行匹配（必须提供全参数构造器，即可实现自动注入这样就无需提供setter方法）
     * */
    private Student student=null;

    @Override
    public void print(){
        System.out.println(student+"\n");
    }
}
