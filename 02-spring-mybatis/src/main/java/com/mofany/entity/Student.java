package com.mofany.entity;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author MoFany-J
 * @date 2022/12/29
 * @description Student
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Short age;
}
