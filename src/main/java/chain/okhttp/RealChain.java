package chain.okhttp;

import java.util.List;

public class RealChain implements Interceptor.Chain {
    private int index;
    private Request request;
    private List<Interceptor> interceptorList;

    public RealChain(int index, Request request, List<Interceptor> interceptorList) {
        this.index = index;
        this.request = request;
        this.interceptorList = interceptorList;
    }

    @Override
    public Response proceed(Request request) {

        RealChain realChain = new RealChain(index + 1,request, interceptorList);

        Interceptor interceptor = interceptorList.get(index);

        return interceptor.intercept(realChain);
    }

    @Override
    public Request request() {
        return this.request;
    }
}
