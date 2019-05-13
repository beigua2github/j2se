package chain.filter;

public class LastFilter implements Filter {
    @Override
    public Response doFilter(Handler handler, Context context) {
        System.out.println("【BEGIN】I'am last,the Req is = " + context.getRequest().getMessage() + ",the Rsp = " + context.getResponse());


        if (context.getRequest().getType().equals("Last")){
            StatisticResponse response1 = new StatisticResponse("Last");
            context.setResponse(response1);
            System.out.println("【END】I'am last,the Req is = " + context.getRequest().getMessage() + ",the Rsp = " + context.getResponse());
            return response1;
        }
        return handler.handle(context);
    }
}
