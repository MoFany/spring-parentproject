package com.mofany.entity;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description Student
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class Student implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private Short age;
}
