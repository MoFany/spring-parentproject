package com.mofany.entity;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/1/7
 * @description Role 角色实体类
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class Role implements Serializable {
    private Integer id;
    private String roleName;
    private String roleDesc;
    /**
     * 联合查询
     * */
    private List<User> userList;
}
