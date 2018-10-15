package com.lh.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static java.sql.Timestamp toTime(Date d) {
        if (null == d)
            return null;
        return new java.sql.Timestamp(d.getTime());
    }

    public static Date toDate(java.sql.Timestamp t) {
        if (null == t)
            return null;
        return new Date(t.getTime());
    }
    public static String format(Date d)
    {
        String str = "";
        if(d!=null)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
            str = dateFormat.format(d);
        }
        return str;
    }
}
