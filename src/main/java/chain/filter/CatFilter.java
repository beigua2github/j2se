package chain.filter;

public class CatFilter implements Filter {
    @Override
    public Response doFilter(Handler handler, Context context) {
        System.out.println("【BEGIN】I'am cat,the req is = " + context.getRequest().getMessage() + ",the Rsp = " + context.getResponse());
        Response response = handler.handle(context);
        response.setMessage(response.getMessage().concat("=>cat"));
        System.out.println("【END】I'am cat,the req is = " + context.getRequest().getMessage() + ",the Rsp = " + context.getResponse());
        return response;
    }
}
