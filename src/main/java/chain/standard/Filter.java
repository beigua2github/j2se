package chain.standard;

import chain.Interceptor.Request;
import chain.Interceptor.Response;

public interface Filter {
    void execute(Request request, Response response);
}
