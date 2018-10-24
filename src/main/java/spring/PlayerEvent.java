package spring;

import org.springframework.context.ApplicationEvent;

/**
 * @author beigua
 */
public class PlayerEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public PlayerEvent(Object source) {
        super(source);
        doSomething();
    }

    public void doSomething() {
        System.out.println("PlayerEvent=>doSomething");
    }
}
