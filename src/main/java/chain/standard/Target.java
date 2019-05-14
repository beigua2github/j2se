package chain.standard;

import chain.Interceptor.Request;
import chain.Interceptor.Response;

public class Target {
    Response execute(Request request) {
        System.out.println("This is Target");
        return null;
    }
}
