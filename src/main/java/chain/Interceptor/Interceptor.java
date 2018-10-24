package chain.Interceptor;

public interface Interceptor{
    Response intercept(InvocationTarget target, Request request);

    interface InvocationTarget{
        Response proceed(Request request);
    }
}
