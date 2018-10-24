package chain.servletfilter;

import com.google.common.collect.Lists;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

/**
 * @author beigua
 */
public class MyFilter implements Filter {
    private List<Hanlder> handlers = Lists.newArrayList();


    @Override
    public void init(FilterConfig filterConfig) {
        handlers.add(M_handler.ONE);
        handlers.add(M_handler.TWO);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MyFilter.Context ctx = new MyFilter.Context(handlers,filterChain,servletRequest,servletResponse);
        ctx.handle();
    }

    @Override
    public void destroy() {

    }

    protected class Context{
        private List<Hanlder> handlers;
        private int index;
        private FilterChain filterChain;
        private ServletRequest servletRequest;
        private ServletResponse servletResponse;
        public Context(List<Hanlder> hanlders,FilterChain filterChain,ServletRequest servletRequest, ServletResponse servletResponse){
            this.handlers = hanlders;
            this.filterChain = filterChain;
            this.servletRequest = servletRequest;
            this.servletResponse = servletResponse;
        }
        public void handle() throws IOException, ServletException {
            if (index < handlers.size()){
                Hanlder hanlder = handlers.get(index++);
                hanlder.handle(this);
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }
    protected interface Hanlder{
        void handle(MyFilter.Context context) throws IOException, ServletException;
    }

    private enum M_handler implements MyFilter.Hanlder{
        ONE{
            @Override
            public void handle(MyFilter.Context context) throws IOException, ServletException {
                System.out.println("This is MyFilter => one");
                context.handle();
            }
        },TWO{
            @Override
            public void handle(MyFilter.Context context) throws IOException, ServletException {
                System.out.println("This is MyFilter => two");
                context.handle();
            }
        }
    }

    public static void main(String[] args) throws IOException, ServletException {
        Filter filter = new MyFilter();
        filter.init(null);
        filter.doFilter(null, null, (servletRequest, servletResponse) -> System.out.println("This is  original Servlet's filterChain "));
    }

}
