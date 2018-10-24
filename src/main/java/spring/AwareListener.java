package spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author beigua
 * @date 2017/4/26
 */
public class AwareListener implements ApplicationListener {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ContextRefreshedEvent){
            ClassPathXmlApplicationContext source = (ClassPathXmlApplicationContext)applicationEvent.getSource();
            System.out.println("listen1 ===>  " + source.getId());
        }

        if (applicationEvent instanceof PlayerEvent) {
            System.out.println("listen1 :count = " + count.incrementAndGet() + " : source = " + applicationEvent.getSource().toString());
        }
    }
}
