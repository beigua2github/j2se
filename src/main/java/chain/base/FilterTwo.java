package chain.base;

import chain.Interceptor.Request;
import chain.Interceptor.Response;

public class FilterTwo extends BaseFilter {
    @Override
    public void execute(Request request, Response response,FilterChain filterChain) {
        System.out.println("This is no.2");
        filterChain.execute(request,response);
    }
}
