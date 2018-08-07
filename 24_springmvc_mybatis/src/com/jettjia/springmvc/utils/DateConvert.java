package com.jettjia.springmvc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


public class DateConvert implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        Date result = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
