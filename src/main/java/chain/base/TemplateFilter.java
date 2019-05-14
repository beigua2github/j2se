package chain.base;

import chain.Interceptor.Request;
import chain.Interceptor.Response;

public abstract class TemplateFilter implements Filter {
    @Override
    public void execute(Request request, Response response, FilterChain filterChain) {
        // Common processing for all filters can go here
        doPreProcessing(request, response, filterChain);

        // Common processing for all filters can go here
        doMainProcessing(request, response, filterChain);

        // Common processing for all filters can go here
        doPostProcessing(request, response, filterChain);

        // Common processing for all filters can go here

        // Pass control to the next filter in the chain or
        // to the target resource
        filterChain.execute(request, response);
    }

    public void doPreProcessing(Request request,
                                Response response, FilterChain chain) {
    }

    public void doPostProcessing(Request request,
                                 Response response, FilterChain chain) {
    }

    public abstract void doMainProcessing(Request request, Response response, FilterChain
            chain);
}
