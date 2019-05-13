package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * Mode:
 *
 * Throughput: 整体吞吐量，例如“1秒内可以执行多少次调用”。
 *
 * AverageTime: 调用的平均时间，例如“每次调用平均耗时xxx毫秒”。
 *
 * SampleTime: 随机取样，最后输出取样结果的分布，例如“99%的调用在xxx毫秒以内，99.99%的调用在xxx毫秒以内”
 *
 * SingleShotTime: 以上模式都是默认一次 iteration 是 1s，唯有 SingleShotTime 是只运行一次。往往同时把 warmup 次数设为0，用于测试冷启动时的性能。
 *
 *
 * Iteration :
 *
 * Iteration 是 JMH 进行测试的最小单位。在大部分模式下，一次 iteration 代表的是一秒，JMH 会在这一秒内不断调用需要 benchmark 的方法，然后根据模式对其采样，计算吞吐量，计算平均执行时间等。
 *
 * Warmup :
 *
 *
 * Warmup 是指在实际进行 benchmark 前先进行预热的行为。为什么需要预热？因为 JVM 的 JIT 机制的存在，如果某个函数被调用多次之后，JVM 会尝试将其编译成为机器码从而提高执行速度。为了让 benchmark 的结果更加接近真实情况就需要进行预热。
 */
@BenchmarkMode(Mode.Throughput) // 测试方法平均执行时间
@OutputTimeUnit(TimeUnit.SECONDS) // 输出结果的时间粒度为微秒
@State(Scope.Thread) // 每个测试线程一个实例
public class JMHDemo {

//    private static Logger log = LoggerFactory.getLogger(JMHDemo.class);

//    @Benchmark
//    public String stringConcat() {
//        String a = "a";
//        String b = "b";
//        String c = "c";
//        String s = a + b + c;
//        return s;
//    }


    @Benchmark
    public String dateFormate() {
        Date time = new Date();
        return DateUtil.formatDate(DateUtil.FORMAT_YYYY_MM_DD_HHMMSS, time);
    }

    @Benchmark
    public int dateDiff() {
        String start = "2018-10-11 17:33:22";
        String end = "2018-10-11 17:33:23";
        return DateUtil.timeDif(start, end);
    }


    public static void main(String[] args) throws RunnerException {
        // 使用一个单独进程执行测试，执行5遍warmup，然后执行5遍测试
        Options opt = new OptionsBuilder().include(JMHDemo.class.getSimpleName()).forks(1).warmupIterations(5)
                .measurementIterations(5).build();
        new Runner(opt).run();
    }
}
