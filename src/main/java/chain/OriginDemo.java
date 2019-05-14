package chain;

import chain.Interceptor.Request;
import chain.Interceptor.Response;

public class OriginDemo {
    /**
     * 是否已通过身份验证？
     * 是否有有效的会话？
     * IP地址是否来自可信IP？
     * 是否需要解码？
     * 等等
     * ******
     * ******
     */
    public Response execute() throws Exception {
        Request request = new Request();
        if (isAuthenticated(request)) {

            if (isValidSession(request)) {

                if (isTrustedIp(request)) {

                    //biz logic
                    return new Response();


                } else {
                    throw new Exception("Untrusted ip");
                }
            } else {
                throw new Exception("Invalid session");
            }
        } else {
            throw new Exception("Authenticated fail");
        }
    }

    private boolean isTrustedIp(Request request) {
        return false;
    }

    private boolean isValidSession(Request request) {
        return false;
    }

    private boolean isAuthenticated(Request request) {
        return false;
    }


}
