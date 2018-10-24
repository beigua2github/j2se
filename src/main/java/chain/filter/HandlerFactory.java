package chain.filter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HandlerFactory {
    private static List<Filter> zoo = new LinkedList<>();
    private static Handler zooHandler = null;

    public static void init(){
        zoo.add(new CatFilter());
        zoo.add(new DogFilter());
        zoo.add(new LastFilter());

        Handler last = null;
        List<Filter> filters = new ArrayList<>();
        filters.addAll(zoo);

        for (int i = filters.size() - 1;i >= 0 ;i --){
            final Filter filter = filters.get(i);
            Handler next = last;
            last = context -> filter.doFilter(next,context);
        }

        zooHandler = last;
    }

    public static Handler getZooHandler() {
        return zooHandler;
    }
}
