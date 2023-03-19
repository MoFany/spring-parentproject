package com.mofany.mapper;

import com.mofany.entity.Role;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/1/7
 * @description RoleMapper
 */
public interface RoleMapper {
    /**
     * 查询每个角色中包含哪些用户，属于一对多
     * */
    List<Role> selectUsersInRole();
}
