package com.mofany.mapper;

import com.mofany.entity.ViewPoint;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/1
 * @description ViewPointMapper
 */
public interface ViewPointMapper {

    /**
     * 新增一条旅游景记录
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
     * 多条件查询
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
