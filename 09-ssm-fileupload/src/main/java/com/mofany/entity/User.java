package com.mofany.entity;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author MoFany-J
 * @date 2023/1/7
 * @description User 用户实体类
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String email;
}
