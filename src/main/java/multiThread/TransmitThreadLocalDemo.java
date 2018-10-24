package multiThread;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TransmitThreadLocalDemo {
    static ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(1);
    static ExecutorService threadPoolExecutor2 = Executors.newFixedThreadPool(1);



    static TransmittableThreadLocal<Cat> local = new TransmittableThreadLocal<>();


    public static void main(String[] args) {
        local.set(Cat.builder().parent("parent").build());


        Runnable t1 = getRunnable("kobe-1");
        Runnable t2 = getRunnable("kobe-2");

        threadPoolExecutor.submit(TtlRunnable.get(t1));
        threadPoolExecutor.submit(TtlRunnable.get(t2));


        sleep();
        System.out.println("-------------------------------------");
        System.out.println(TransmitThreadLocalDemo.local.get());

        System.out.println("#######################################");


        Runnable t3 = getRunnable("kobe-3");
        Runnable t4 = getRunnable("kobe-4");

        threadPoolExecutor2.submit(TtlRunnable.get(t3));
        threadPoolExecutor2.submit(TtlRunnable.get(t4));

        sleep();

        System.out.println("-------------------------------------");
        System.out.println(TransmitThreadLocalDemo.local.get());

        threadPoolExecutor.shutdown();
        threadPoolExecutor2.shutdown();

    }

    private static Runnable getRunnable(String value) {
        return () -> {

            Cat cat = TransmitThreadLocalDemo.local.get();
            System.out.println(TransmitThreadLocalDemo.local.get());

            cat.setChild(StringUtils.defaultString(cat.getChild() ,"Start:").concat(value + "=>"));
            TransmitThreadLocalDemo.local.set(cat);

            System.out.println(TransmitThreadLocalDemo.local.get());
        };
    }

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Cat {
    private String parent;
    private String child;
}
