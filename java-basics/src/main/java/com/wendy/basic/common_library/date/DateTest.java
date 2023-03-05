package com.wendy.basic.common_library.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/12/9 22:38
 * @Version 1.0
 */
public class DateTest {
    public static void main(String[] args)throws Exception {
        // Calendar使用不多，会用其获取年月日即可
        System.out.println("Calendar测试------------------");
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.getTimeInMillis());

        // 日期类直接输出是西方的格式
        System.out.println("Date测试-------------------------");
        Date today = new Date();
        System.out.println(today);
        System.out.println(today.getTime()); //返回时间戳数字

        // 时间戳继承自Date
        Timestamp timestamp = new Timestamp(4154356);
        System.out.println("时间戳: "+timestamp+"----------------------------");
        Timestamp timestamp1 = Timestamp.valueOf("2021-12-09 23:00:00");
        System.out.println(timestamp1);

        System.out.println("SimpleDateFormat的使用----------------------------------");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.out.println(simpleDateFormat.getCalendar().getTime());

        System.out.println("字符串与日期的转化------------------------------");
        /*
         * 因为使用Date类与字符串时间相互转化十分困难，因此，考虑Date类的其他子类。
         * DateFormat是日期/时间格式化子类的抽象类，它与以语言无关的方式格式化并解析日期或时间，
         * 是抽象类，所以使用其子类SimpleDateFormat实现日期和字符串的相互转换。*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 将字符串转化为日期
        Date date1 = sdf.parse("2000-12-16 16:52:39");
        System.out.println(date1);
        //将日期格式化为标准字符串
        Date date2 = new Date();
        String str = sdf.format(date2);
        System.out.println(str);
    }
}
