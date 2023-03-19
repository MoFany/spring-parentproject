package com.mofany.service.impl;

import com.mofany.entity.ViewPoint;
import com.mofany.mapper.ViewPointMapper;
import com.mofany.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/1
 * @description ViewPointServiceImpl
 */
@Service
public class ViewPointServiceImpl implements ViewPointService {

    private ViewPointMapper viewPointMapper;
    /**
     * 构造器注入
     * */
    @Autowired
    public ViewPointServiceImpl(ViewPointMapper viewPointMapper){
        this.viewPointMapper=viewPointMapper;
    }

    /**
     * 按实体插入
     * */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = java.lang.RuntimeException.class)
    @Override
    public int insertByEntity(ViewPoint viewPoint) {
        return viewPointMapper.insertByEntity(viewPoint);
    }

    /**
     * 删除与批量删除旅游景点记录
     *
     * @param ids
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = java.lang.RuntimeException.class)
    @Override
    public int deleteByIds(List ids) {
        return viewPointMapper.deleteByIds(ids);
    }

    /**
     * 旅游景点信息的修改
     *
     * @param viewPoint
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = java.lang.RuntimeException.class)
    @Override
    public int updateByEntity(ViewPoint viewPoint) {
        return viewPointMapper.updateByEntity(viewPoint);
    }


    /**
     * 按实体字段进行多条件查询
     *
     * @param viewPoint
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public ViewPoint selectByEntity(ViewPoint viewPoint) {
        return viewPointMapper.selectByEntity(viewPoint);
    }

    /**
     * 分页联合查询
     *
     *
     */
    @Override
    public List<ViewPoint> SelectByPage() {
        return viewPointMapper.SelectByPage();
    }

    /**
     * 多条件分页联合查询
     */
    @Override
    public List<ViewPoint> SelectByPages(ViewPoint viewPoint) {
        return viewPointMapper.SelectByPages(viewPoint);
    }
}
