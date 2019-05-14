package chain.base;

import chain.Interceptor.Request;
import chain.Interceptor.Response;

public class FilterThree extends TemplateFilter {
    @Override
    public void doPreProcessing(Request req,
                                Response res, FilterChain chain) {
        //do some preprocessing here
        System.out.println("FilterThree.doPreProcessing()");
    }

    @Override
    public void doMainProcessing(Request request, Response response, FilterChain chain) {
        //do some core here
        System.out.println("FilterThree.doMainProcessing()");
    }
}
