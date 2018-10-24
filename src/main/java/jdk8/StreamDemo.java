package jdk8;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.lang.System.out;

public class StreamDemo {
    public static void main(String[] args) {
        String[] split = "3,1,2".split(",");


        Stopwatch stopwatch = Stopwatch.createStarted();
        Set<Integer> psIds = Sets.newHashSet();
        for (String str:split){
            psIds.addAll(getIds(Integer.valueOf(str)));
        }

        List<String> strs = Lists.newArrayList();
        for (Integer id:psIds){
            strs.addAll(getObject(id));
        }

        System.out.print(strs);
        System.out.print("耗时:");
        System.out.println(stopwatch.elapsed(TimeUnit.MICROSECONDS));


        Stopwatch stopwatch1 = Stopwatch.createStarted();
        Stream.of(split)
                .parallel()
                .map(Integer::valueOf)
                .flatMap(p -> getIds(p).stream())
                .distinct()
                .flatMap(p -> getObject(p).stream())
                .forEach(out::print);
        System.out.print("耗时:");

        System.out.println(stopwatch1.elapsed(TimeUnit.MICROSECONDS));
    }

    private static List<Integer> getIds(int pro){
        return Lists.newArrayList(1,2,3);
    }

    private static List<String> getObject(int pro) {
        sleep();

        List<String> list = null;
        switch (pro){
            case 1: list = Lists.newArrayList("kobe");break;
            case 2: list = Lists.newArrayList("jordan");break;
            case 3: list = Lists.newArrayList("james");break;
            default:list = Lists.newArrayList("tracy");
        }

        return list;
    }

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }
    }
}
