package chain.Interceptor;

import java.util.List;

public class InterceptorChain implements Interceptor.InvocationTarget {
    private List<? extends  Interceptor> list;
    private Handler handler;
    private int index = 0;

    public InterceptorChain(List<? extends  Interceptor> list ,Handler handler){
        this.list = list;
        this.handler = handler;
    }

    @Override
    public Response proceed(Request request) {
        if (list.size() == index){
            return handler.proceed(request);
        }

        Interceptor interceptor = list.get(index);

        index ++ ;
        return interceptor.intercept(this::proceed,request);
    }
}
