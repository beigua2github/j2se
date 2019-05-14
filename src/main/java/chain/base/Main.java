package chain.base;

import chain.Interceptor.Request;

public class Main {
    public static void main(String[] args) {
        Request request = new Request();

        FilterManager filterManager = new FilterManager();

        filterManager.execute(request);
    }
}
