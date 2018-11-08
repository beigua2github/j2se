package string;

public class HelloDemo {
    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                System.out.println("I quit")
        ));

        System.out.println("Hello,world!");
    }
}
