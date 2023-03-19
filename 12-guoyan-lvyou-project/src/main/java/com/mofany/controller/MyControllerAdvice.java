package com.mofany.controller;

import com.mofany.converters.DateConvert;
import com.mofany.converters.TimeConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;


/**
 * @author MoFany-J
 * @date 2023/2/2
 * @description MyControllerAdvice 定义全局数据绑定器
 */
@ControllerAdvice
public class MyControllerAdvice {
    private DateConvert dateConvert;
    private TimeConvert timeConvert;

    /**
     * 构造器注入
     * */
    @Autowired
    public MyControllerAdvice(DateConvert dateConvert,TimeConvert timeConvert){
        this.dateConvert=dateConvert;
        this.timeConvert=timeConvert;
    }

    /**
     * 使用日期转换器
     * */
    @InitBinder
    public void dateTypeBinder(WebDataBinder webDataBinder){
        //获取转换服务对象
        ConversionService conversionService=webDataBinder.getConversionService();
        //判断conversionService是否为GenericConversionService类型
        if (conversionService instanceof GenericConversionService){
            //强制类型转换
            GenericConversionService genericConversionService=(GenericConversionService) conversionService;
            //添加类型转换器
            genericConversionService.addConverter(dateConvert);
        }
    }

    /**
     * 使用时间转换器
     * */
    @InitBinder
    public void timeTypeBinder(WebDataBinder webDataBinder){
        //获取转换服务对象
        ConversionService conversionService=webDataBinder.getConversionService();
        //判断conversionService是否为GenericConversionService类型
        if (conversionService instanceof GenericConversionService){
            //强制类型转换
            GenericConversionService genericConversionService=(GenericConversionService) conversionService;
            //添加类型转换器
            genericConversionService.addConverter(timeConvert);
        }
    }
}
