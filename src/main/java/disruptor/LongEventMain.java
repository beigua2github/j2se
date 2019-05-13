package disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LongEventMain {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();

        LongEventFactory factory = new LongEventFactory();

        int bufferSize = 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, bufferSize, executor);

        EventHandlerGroup<LongEvent> longEventEventHandlerGroup = disruptor.handleEventsWith(new LongEventHandler());
        longEventEventHandlerGroup.then((EventHandler<LongEvent>) (event, sequence, endOfBatch) -> System.out.println("end"));


        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);

        for (long l = 0; l < 10; l++) {
            bb.putLong(0, l);

            producer.onData(bb);

            Thread.sleep(1000);
        }


        disruptor.shutdown();
        ((ExecutorService) executor).shutdown();

    }
}
