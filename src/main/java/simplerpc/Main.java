package simplerpc;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EchoService echoService = MyRpc.referService(EchoService.class, "127.0.0.1", 5535);

        for (int i= 0 ; i < Integer.MAX_VALUE; i++) {
            System.out.println(echoService.say("hello ") + i);
            Thread.sleep(1000);
            System.out.println(echoService.sing("song ") + i);
        }
    }
}
