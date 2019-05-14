package chain.standard;


import chain.Interceptor.Request;
import chain.Interceptor.Response;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    private List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    public void execute(Request request,Response response) {
        this.filters.stream().forEach(it -> it.execute(request,response));
    }
}
