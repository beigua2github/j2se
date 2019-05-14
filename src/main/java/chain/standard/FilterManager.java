package chain.standard;

import chain.Interceptor.Request;
import chain.Interceptor.Response;

public class FilterManager {
    private FilterChain chain = new FilterChain();
    private Target target;


    public FilterManager() {
        this.chain.addFilter(new FilterOne());
        this.chain.addFilter(new FilterTwo());
        this.chain.addFilter(new FilterThree());
        this.target = new Target();
    }

    public Response execute(Request request){
        this.chain.execute(request,new Response());
        return target.execute(request);
    }
}
