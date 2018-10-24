package spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author beigua
 * @date 2017/4/26
 */
public class AwareListener2 implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ContextRefreshedEvent) {
            ClassPathXmlApplicationContext source = (ClassPathXmlApplicationContext) applicationEvent.getSource();
            System.out.println("listen2 ===>  " + source.getId());
        }
    }
}
