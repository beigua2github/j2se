package chain.Interceptor;

import com.google.common.collect.Lists;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Interceptor> interceptorList = Lists.newArrayList();

        Interceptor i1 = (target, request) -> doProceed(target, request);

        Interceptor i2 = (target, request) -> doProceed(target, request);

        interceptorList.add(i1);
        interceptorList.add(i2);

        Request request = new Request();
        Response proceed = new InterceptorChain(interceptorList, new DefaultHandler()).proceed(request);
        System.out.println("req" + request);
        System.out.println("rsp" + proceed);

    }

    private static Response doProceed(Interceptor.InvocationTarget target, Request request) {
        Response res = target.proceed(request);
        int reqNo = request.getReqNo();
        request.setReqNo(++reqNo);
        int rspNo = res.getRspNo();
        res.setRspNo(++rspNo);
        return res;
    }
}
