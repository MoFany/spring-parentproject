package com.mofany.entity;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

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
public class Teacher implements Serializable {
    private Integer jobNum;
    private String name;
    private String sex;
    private String subject;
}
