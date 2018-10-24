package simplerpc;

/**
 * @author beigua
 */
public interface EchoService {
    /**
     * @param message
     * @return
     */
    String say(String message);

    /**
     * @param message
     * @return
     */
    String sing(String message);
}
