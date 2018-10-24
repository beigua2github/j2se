package chain.filter;

public interface Filter {
    Response doFilter(Handler handler,Context context);
}
