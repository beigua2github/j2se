package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by beigua on 2017/4/26.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AwareDemo awareDemo = applicationContext.getBean("awareDemo",AwareDemo.class);
        awareDemo.sayHello();
    }
}
