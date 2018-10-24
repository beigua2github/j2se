package jdk8;


import com.google.common.collect.Maps;

import java.text.MessageFormat;
import java.util.Map;
import java.util.stream.Collectors;

public class Comment {
    public static boolean operate(Integer a, Integer b) {
        return a.compareTo(b) >= 0;
    }

    public static void main(String[] args) {
        Map<String, String> map = Maps.newTreeMap();
        map.put("100", "2");
        map.put("200", "4");
        map.put("500", "6");
        map.put("1000", "8");

        map.entrySet()
                .parallelStream()
                .collect(Collectors.toMap(Map.Entry::getKey, (it) -> "\""+ it.getValue() + "\"" ));


        System.out.println(MessageFormat.format("'{0}'-{1}", 1, 2));  // 结果{0}-2

        String msg = "{0}{1}{2}{3}{4}{5}{6}{7}{8}";
        Object [] array = new Object[]{"A","B","C","D","E","F","G","H","I",};
        String value = MessageFormat.format(msg, array);

        System.out.println(value);  // 输出：ABCDEFGHI


        String format = MessageFormat.format("'{'{0}}", "X-rapido");// {X-rapido}

        System.out.println(format);


//        String value1 = MessageFormat.format("oh, {{ is good num", "d");
//        String value2 = MessageFormat.format("oh, { is good num", "d");

//        System.out.println(value1);  // oh,
//        System.out.println(value2);  // exception in thread "main" java.lang.IllegalArgumentException: Unmatched braces in the pattern

        System.out.println(System.nanoTime());
    }
}
