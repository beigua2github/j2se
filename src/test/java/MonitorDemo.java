public class MonitorDemo {
    public static void main(String[] args) {
        System.out.println("Hello,world!");
    }

    public synchronized void hello() {
        System.out.println("hello");

    }

    public void world() {
        System.out.println("world");
    }

    public void lock() {
        synchronized (MonitorDemo.class){
            System.out.println("hello");
        }


        synchronized (this){
            System.out.println("hello");
        }
    }

}
