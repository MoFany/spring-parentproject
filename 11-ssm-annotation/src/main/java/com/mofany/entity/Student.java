package com.mofany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author MoFany-J
 * @date 2023/1/25
 * @description Student
 */
@Component
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Student implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private Short age;
}
