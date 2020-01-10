package com.scau.ssm.uitls;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private DateUtils(){}

    public static Date strToDate(String dateStr, String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateToStr(Date date, String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

}
