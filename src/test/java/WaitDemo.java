public class WaitDemo {
    // Not efficient
    private volatile boolean flag = false;

    public void waitTillChange() throws InterruptedException {
        while (!flag) {
            System.out.println("哥睡了");
            Thread.sleep(100);
        }
    }

    public void change() {
        flag = true;
    }

    public static void main(String[] args) {
        final WaitDemo waitDemo = new WaitDemo();

        new Thread(() ->{
            try {
                waitDemo.waitTillChange();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> waitDemo.change()).start();


    }
}
