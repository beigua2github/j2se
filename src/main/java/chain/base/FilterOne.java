package chain.base;

import chain.Interceptor.Request;
import chain.Interceptor.Response;

public class FilterOne extends BaseFilter {
    @Override
    public void execute(Request request, Response response,FilterChain filterChain) {
        System.out.println("This is no.1");
        super.setConfigMap(null);
        filterChain.execute(request,response);
    }
}
