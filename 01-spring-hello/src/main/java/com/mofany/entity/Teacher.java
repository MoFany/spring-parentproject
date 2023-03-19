package com.mofany.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author MoFany-J
 * @date 2022/12/21
 * @description Teacher
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Teacher implements Serializable {
    private Integer jobnum;
    private String name;
    private String sex;
    private String subject;
}
