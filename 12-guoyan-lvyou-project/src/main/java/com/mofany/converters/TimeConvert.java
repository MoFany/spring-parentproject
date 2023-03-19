package com.mofany.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MoFany-J
 * @date 2023/2/3
 * @description TimeConvert 自定义时间转换器
 */
@Component
public class TimeConvert implements Converter<String, Time> {

    @Override
    public Time convert(String source) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
        try {
            Date parse = dateFormat.parse(source);
            Time time=new Time(parse.getHours(),parse.getMinutes(),parse.getSeconds());
            return time;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
