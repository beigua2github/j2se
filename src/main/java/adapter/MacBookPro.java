package adapter;

public class MacBookPro implements MacTypeC {
    private MacTypeC macTypeC;

    public MacBookPro(MacTypeC macTypeC) {
        this.macTypeC = macTypeC;
    }

    @Override
    public void work() {
        this.macTypeC.work();
    }
}
