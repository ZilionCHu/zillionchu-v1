package com.zillionchu.common.utils.date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {

    public static final String C_DATE_DIVISION = "-";
    public static final String C_TIME_PATTON_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String C_DATE_PATTON_DEFAULT = "yyyy-MM-dd";
    public static final String C_DATA_PATTON_YYYYMMDD = "yyyyMMdd";
    public static final String C_DATA_PATTON_YYYYMM = "yyyyMM";
    public static final String C_TIME_PATTON_HHMMSS = "HH:mm:ss";
    public static final String C_TIME_STAMP = "yyyyMMddHHmmssSSS";

    public static final int C_ONE_SECOND = 1000;
    public static final int C_ONE_MINUTE = 60 * C_ONE_SECOND;
    public static final int C_ONE_HOUR = 60 * C_ONE_MINUTE;
    public static final long C_ONE_DAY = 24l * C_ONE_HOUR;

    /**
     * 获取当前时间
     *
     * @return － DATE<br>
     */
    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 获取当前时间并按指定格式格式化
     *
     * @return － 产生的日期字符串 默认格式 C_DATE_PATTON_DEFAULT
     */
    public static String getCurrentDateStr() {
        return format(getCurrentDate());
    }

    /**
     * 获取当前时间并按指定格式格式化
     *
     * @param strFormat
     * @return
     */
    public static String getCurrentDateStr(String strFormat) {
        return format(getCurrentDate(), strFormat);
    }

    /**
     * 将日期字符串转换为格式为C_DATE_PATTON_DEFAULT的字符串
     *
     * @param dateValue
     * @return
     * @throws Exception
     */
    public static Date parseDate(String dateValue) throws ParseException {
        return parseDate(C_DATE_PATTON_DEFAULT, dateValue);
    }

    /**
     * 将时间字符串转换为时间 格式默认为C_TIME_PATTON_DEFAULT
     *
     * @param dateValue
     * @return
     * @throws ParseException
     * @throws Exception
     */
    public static Date parseDateTime(String dateValue) throws ParseException {
        return parseDate(C_TIME_PATTON_DEFAULT, dateValue);
    }

    /**
     * 将日期字符串转换为指定格式的日期。
     *
     * @param strFormat
     * @param dateValue
     * @return
     * @throws ParseException
     * @throws Exception
     */
    public static Date parseDate(String strFormat, String dateValue) throws ParseException {
        if (StringUtils.isEmpty(strFormat) || StringUtils.isEmpty(dateValue)) {
            return null;
        }
        return new SimpleDateFormat(StringUtils.isEmpty(strFormat) ? strFormat : C_TIME_PATTON_DEFAULT)
                .parse(dateValue);
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy/MM/dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate2(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 将Timestamp类型的日期转换为系统参数定义的格式的字符串。
     *
     * @param aTs_Datetime 需要转换的日期
     * @return 转换后符合给定格式的日期字符串
     */
    public static String format(Date aTs_Datetime) {
        return format(aTs_Datetime, C_DATE_PATTON_DEFAULT);
    }

    /**
     * 将Timestamp类型的日期转换为系统参数定义的格式的字符串。
     *
     * @param aTs_Datetime 需要转换的日期
     * @return 转换后符合给定格式的日期字符串
     */
    public static String formatTime(Date aTs_Datetime) {
        return format(aTs_Datetime, C_TIME_PATTON_DEFAULT);
    }

    /**
     * 将Date类型的日期转换为系统参数定义的格式的字符串。
     *
     * @param aTs_Datetime
     * @param as_Pattern
     * @return
     */
    public static String format(Date aTs_Datetime, String as_Pattern) {
        if (aTs_Datetime == null || StringUtils.isEmpty(as_Pattern)) {
            return null;
        }
        return new SimpleDateFormat(as_Pattern).format(aTs_Datetime);
    }


    /**
     * 取得指定日期N天后的日期
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetween(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 计算当前日期相对于"1977-12-01"的天数
     *
     * @param date
     * @return
     */
    public static long getRelativeDays(Date date) throws ParseException {
        return daysBetween(parseDate(C_DATE_PATTON_DEFAULT, "1977-12-01"), date);
    }


    /**
     * 返回中文日期格式  #年#月#日 #时#分#秒
     *
     * @param dt
     * @return
     */
    public static String getChineseTimeString(Date dt) {
        if (null == dt) {
            return "";
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        String strMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        if (strMonth.length() == 1) {
            strMonth = "0" + strMonth;
        }
        String strDay = String.valueOf(calendar.get(Calendar.DATE));
        if (strDay.length() == 1) {
            strDay = "0" + strDay;
        }
        String strHour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        if (strHour.length() == 1) {
            strHour = "0" + strHour;
        }
        String strMinute = String.valueOf(calendar.get(Calendar.MINUTE));
        if (strMinute.length() == 1) {
            strMinute = "0" + strMinute;
        }
        String strSecond = String.valueOf(calendar.get(Calendar.SECOND));
        if (strSecond.length() == 1) {
            strSecond = "0" + strSecond;
        }
        return calendar.get(Calendar.YEAR) + "年" + strMonth + "月" + strDay + "日" + strHour + "时" + strMinute + "分" +
                strSecond + "秒";
    }

    /**
     * 根据date加减add月,获得对应的日期
     * date可以为空，如果为空默认为系统日期，add可以为正数，也可为负数
     *
     * @param date
     * @param add
     * @return
     * @author penggang
     */
    public static Date getAddMonth(Date date, int add) {
        if (date == null) {
            return Calendar.getInstance().getTime();
        }
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, add);
        return c.getTime();
    }

    /**
     * 解析YYYYMM字符，使其转换为Date类型
     *
     * @param str
     * @return
     */
    public static Date parseYM(String str) {
        DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern(C_DATA_PATTON_YYYYMM);
        DateTime date = DateTime.parse(str, dateTimeFormat);
        return date.toDate();
    }

    public static void main(String[] args) {

//        SimpleDateFormat format = new SimpleDateFormat(C_DATA_PATTON_YYYYMM);
//        System.out.println(format.format(getAddMonth(null, -1)));
//        String str = "201803";
//        DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern(C_DATA_PATTON_YYYYMM);
//
//        DateTime date = DateTime.parse(str, dateTimeFormat);
//        System.out.println(date.toDate().toString());

        System.out.println(getCurrentDate());
    }


}
