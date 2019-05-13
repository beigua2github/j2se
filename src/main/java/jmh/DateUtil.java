package jmh;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public static final String FORMAT_YYYY_MM_DD_HHMMSS ="yyyy-MM-dd HH:mm:ss";


    /**
     * 日期按照指定格式转字符
     * @param pattern
     * @param date
     * @return
     */
    public static String formatDate(String pattern, Date date) {
        if(date == null){
            return "";
        }
        return transToLocalDateTime(date).format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 字符按指定格式转日期
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date parseDate(String dateStr,String pattern) {
        return transToDate(LocalDate.parse(dateStr,DateTimeFormatter.ofPattern(pattern)));
    }

    /**
     * 字符按指定格式转日期
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date parseDateTime(String dateStr,String pattern) {
        return transToDate(LocalDateTime.parse(dateStr,DateTimeFormatter.ofPattern(pattern)));
    }


    public static int timeDif(String start,String end){
        Date startTime = parseDateTime(start,FORMAT_YYYY_MM_DD_HHMMSS);
        Date endTime = parseDateTime(end,FORMAT_YYYY_MM_DD_HHMMSS);
        long timeDif = (startTime.getTime() - endTime.getTime())/1000;
        int secondDif = timeDif >0 ?(int) timeDif: (int)Math.abs(timeDif);
        return secondDif;
    }

    private static LocalDate transToLocalDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    private static LocalDateTime transToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    private static Date transToDate(LocalDate localDate){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }

    private static Date transToDate(LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }
}
