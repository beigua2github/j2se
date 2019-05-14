package chain.base;


import chain.Interceptor.Request;
import chain.Interceptor.Response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterChain {
    private final List<Filter> filters = new ArrayList<>();
    private Iterator<Filter> iterator;


    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    public void execute(Request request,Response response) {
        if (this.iterator == null) {
            this.iterator = this.filters.iterator();
        }

        if (iterator.hasNext()){
            Filter next = iterator.next();
            next.execute(request,response,this);
        }

    }
}
