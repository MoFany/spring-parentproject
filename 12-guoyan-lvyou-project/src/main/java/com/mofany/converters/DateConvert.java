package com.mofany.converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MoFany-J
 * @date 2023/2/2
 * @description DateConvert 自定义日期时间转换器类
 */
@Component
public class DateConvert implements Converter<String, Date> {


    @Override
    public Date convert(String source) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        try {
            Date date=dateFormat.parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
