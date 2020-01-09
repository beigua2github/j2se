package adapter;

public class HooTooAdapter implements MacTypeC {
    private WinUsb winUsb;

    public HooTooAdapter() {
        this.winUsb = new WinUsb();
    }

    @Override
    public void work() {
        winUsb.work();
    }
}
