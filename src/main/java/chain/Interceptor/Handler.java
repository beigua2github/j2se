package chain.Interceptor;

public interface Handler extends Interceptor.InvocationTarget {
    Response proceed(Request request);
}
