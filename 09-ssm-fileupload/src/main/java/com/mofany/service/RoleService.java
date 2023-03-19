package com.mofany.service;

import com.mofany.entity.Role;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/1/7
 * @description RoleService
 */
public interface RoleService {
    /**
     * 查询每个角色中包含哪些用户，属于一对多
     * */
    List<Role> selectUsersInRole();
}
