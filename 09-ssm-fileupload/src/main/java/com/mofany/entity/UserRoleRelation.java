package com.mofany.entity;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author MoFany-J
 * @date 2023/1/7
 * @description UserRoleRelation 用户角色关系实体类
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class UserRoleRelation implements Serializable {
    private Integer id;
    private Integer user_id;
    private Integer role_id;
}
