package com.mofany.entity;

import lombok.*;
import org.springframework.stereotype.Repository;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description Teacher
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class Teacher {
    private Integer jobnum;
    private String name;
    private String sex;
    private String subject;
}
