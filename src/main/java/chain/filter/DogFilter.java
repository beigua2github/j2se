package chain.filter;

public class DogFilter implements Filter {
    @Override
    public Response doFilter(Handler handler, Context context) {
        System.out.println("【BEGIN】I'am dog,the Req is = " + context.getRequest().getMessage() + ",the Rsp = " + context.getResponse());
        Response response = handler.handle(context);
        response.setMessage(response.getMessage().concat("=>dog"));
        System.out.println("【END】I'am dog,the Req is = " + context.getRequest().getMessage() + ",the Rsp = " + context.getResponse());
        return response;
    }
}
