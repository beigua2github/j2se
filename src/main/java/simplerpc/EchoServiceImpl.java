package simplerpc;

/**
 * @author beigua
 */
public class EchoServiceImpl implements EchoService {
    @Override
    public String say(String message) {
        return "Get message: " + message;
    }

    @Override
    public String sing(String message) {
        return "Look message: " + message;
    }
}
