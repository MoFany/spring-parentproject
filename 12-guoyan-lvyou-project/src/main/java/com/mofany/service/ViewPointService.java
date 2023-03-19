package com.mofany.service;

import com.mofany.entity.ViewPoint;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/1
 * @description ViewPointService
 */
public interface ViewPointService {

    /**
     * 新增
     * */
    int insertByEntity(ViewPoint viewPoint);

    /**
     * 删除与批量删除旅游景点记录
     * */
    int deleteByIds(List ids);

    /**
     * 旅游景点信息的修改
     * */
    int updateByEntity(ViewPoint viewPoint);

    /**
     * 按实体字段进行多条件查询
     * */
    ViewPoint selectByEntity(ViewPoint viewPoint);

    /**
     * 分页联合查询
     * */
    List<ViewPoint> SelectByPage();

    /**
     * 多条件分页联合查询
     * */
    List<ViewPoint> SelectByPages(ViewPoint viewPoint);
}
