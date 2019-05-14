package chain.base;

import chain.Interceptor.Request;
import chain.Interceptor.Response;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class BaseFilter implements Filter {
    @Setter
    @Getter
    private Map<String,String> configMap;

    @Override
    public void execute(Request request, Response response,FilterChain filterChain) {
        System.out.println("This is base");
    }
}
