package chain.filter;

import lombok.Getter;
import lombok.Setter;

public class Main {
    public static void main(String[] args) {
        HandlerFactory.init();

        Handler zooHandler = HandlerFactory.getZooHandler();

        Context context = new Context() {
            @Setter
            @Getter
            private Request request;
            @Setter
            @Getter
            private Response response;
        };

        Request request = new StatisticRequest("Last");
        context.setRequest(request);

        System.out.println("The Request is " + request.getMessage());

        Response handle = zooHandler.handle(context);

        System.out.println("The Response is " + handle.getMessage());

    }
}
