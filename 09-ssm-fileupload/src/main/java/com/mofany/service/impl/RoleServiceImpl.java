package com.mofany.service.impl;

import com.mofany.entity.Role;
import com.mofany.mapper.RoleMapper;
import com.mofany.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/1/7
 * @description RoleServiceImpl
 */
@Service
public class RoleServiceImpl implements RoleService {

    private RoleMapper roleMapper;
    /**
     * 构造器注入
     * */
    @Autowired
    private RoleServiceImpl(RoleMapper roleMapper){
        this.roleMapper=roleMapper;
    }
    /**
     * 查询每个角色中包含哪些用户，属于一对多
     */
    @Override
    public List<Role> selectUsersInRole() {
        return roleMapper.selectUsersInRole();
    }
}
