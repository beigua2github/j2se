package chain.standard;

import chain.Interceptor.Request;
import chain.Interceptor.Response;

public class FilterTwo implements Filter {
    @Override
    public void execute(Request request, Response response) {
        System.out.println("This is no.2");
    }
}
