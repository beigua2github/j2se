package chain.filter;

public interface Context {
    Request getRequest();
    void setRequest(Request request);
    Response getResponse();
    void setResponse(Response response);
}
