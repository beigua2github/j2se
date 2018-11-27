package disruptor;


import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) {
        System.out.println("Event: " + longEvent.getValue() + ",seq :" + l);
    }
}
