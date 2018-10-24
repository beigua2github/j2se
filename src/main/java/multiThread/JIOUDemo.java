package multiThread;

public class JIOUDemo {
    public int getStart() {
        return start;
    }

    public boolean isJi() {
        return isJi;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setJi(boolean ji) {
        isJi = ji;
    }

    private volatile int start = 1;
    private volatile boolean isJi = true;

    public static void main(String[] args) {
        JIOUDemo jiouDemo = new JIOUDemo();
        new Ji(jiouDemo).start();
        new Ou(jiouDemo).start();
    }

}
class Ji extends Thread{
    private JIOUDemo jiouDemo;
    public Ji(JIOUDemo jiouDemo){
        this.jiouDemo = jiouDemo;
    }

    @Override
    public void run() {
        synchronized (JIOUDemo.class){
            while (jiouDemo.getStart() <= 100){
                if (jiouDemo.isJi()){
                    System.out.println("我是奇数" + jiouDemo.getStart());
                    jiouDemo.setStart(jiouDemo.getStart() + 1);
                    jiouDemo.setJi(false);
                    JIOUDemo.class.notify();
                }else {
                    try {
                        JIOUDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Ou extends Thread{
    private JIOUDemo jiouDemo;
    public Ou(JIOUDemo jiouDemo){
        this.jiouDemo = jiouDemo;
    }


    @Override
    public void run() {
        synchronized (JIOUDemo.class){
            while (jiouDemo.getStart() <= 100){
                if (!jiouDemo.isJi()){
                    System.out.println("我是偶数" + jiouDemo.getStart());
                    jiouDemo.setStart(jiouDemo.getStart() + 1);
                    jiouDemo.setJi(true);
                    JIOUDemo.class.notify();
                }else {
                    try {
                        JIOUDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}