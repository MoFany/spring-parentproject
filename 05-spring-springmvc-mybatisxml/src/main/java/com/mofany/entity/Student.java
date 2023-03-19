package com.mofany.entity;

import lombok.*;
import org.springframework.stereotype.Repository;

/**
 * @author MoFany-J
 * @date 2023/1/4
 * @description Student 实体
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Short age;
}
