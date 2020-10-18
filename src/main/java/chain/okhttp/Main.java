package chain.okhttp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Interceptor> list = new ArrayList<>();

        list.add(new InterceptorOne());
        list.add(new InterceptorTwo());
        list.add(new InterceptorLast());

        RealChain realChain = new RealChain(0, new Request(), list);

        Response response = realChain.proceed(realChain.request());

    }
}

class InterceptorOne implements Interceptor{

    @Override
    public Response intercept(Chain chain) {
        System.out.println("I am One!");
        chain.request().addOne("one");

        return chain.proceed(chain.request());
    }
}

class InterceptorTwo implements Interceptor{

    @Override
    public Response intercept(Chain chain) {
        System.out.println("I am Two!");
        chain.request().addOne("Two");
        return chain.proceed(chain.request());
    }
}

class InterceptorLast implements Interceptor{

    @Override
    public Response intercept(Chain chain) {
        System.out.println("I am Last!");
        chain.request().addOne("Last");
        return new Response();
    }
}

class InterceptorThree implements Interceptor{

    @Override
    public Response intercept(Chain chain) {
        return null;
    }
}
