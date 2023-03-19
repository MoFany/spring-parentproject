package com.mofany.util;

import com.mofany.entity.Teacher;

/**
 * @author MoFany-J
 * @date 2022/12/25
 * @description TeacherFactoryUtil
 */
public class TeacherFactoryUtil {

    private static Teacher teacher = null;

    private TeacherFactoryUtil() {
        throw new RuntimeException("禁止反射！");
    }

    /**
     * 工厂初始化
     * */
    public static Teacher initTeacherFactory(Integer jobnum, String name, String sex, String subject) {
        if (teacher == null) {
            synchronized (TeacherFactoryUtil.class) {
                if (teacher == null) {
                    teacher = new Teacher(jobnum, name, sex, subject);
                }
            }
        }
        return teacher;
    }

}
