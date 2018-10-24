package chain.Interceptor;

public class DefaultHandler implements Handler {
    @Override
    public Response proceed(Request request) {
        System.out.println("This is default handler");
        return new Response();
    }
}
