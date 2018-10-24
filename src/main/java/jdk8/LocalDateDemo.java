package jdk8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = localDate.plusDays(-1);
        System.out.println(localDate.isAfter(localDate1));

        System.out.println(localDate);
        System.out.println(localDate.plusDays(1));
        System.out.println(localDate.minusMonths(1));

        System.out.println(Clock.systemUTC().millis());
        System.out.println(Instant.now());

        //LocalDate 转 日期字符串
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        //日期字符串 转 LocalDate
        String dateStr = "2017-09-13";
        System.out.println(LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals(LocalDate.now()));

        //老的Date 转换为 新的LocalDateTime
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());

        //新的LocalDateTime 转换为 老的Date
        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(out.getTime());
    }
}
