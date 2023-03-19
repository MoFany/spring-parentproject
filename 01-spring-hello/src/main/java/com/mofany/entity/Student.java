package com.mofany.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author MoFany-J
 * @date 2022/12/21
 * @description Student
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private short age;
}
