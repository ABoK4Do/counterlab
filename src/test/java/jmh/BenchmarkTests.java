package jmh;

import counter.Counter;
import counter.LockCounter;
import counter.MutexCounter;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Measurement(iterations = 5)
@Warmup(iterations = 2)
@BenchmarkMode(Mode.Throughput)
@Threads(10)
public class BenchmarkTests {
    Counter mutexCounter = new MutexCounter();
    Counter lockCounter = new LockCounter();

    @Benchmark
    @Group("mutexCounter")
    @GroupThreads(5)
    public void testMutexCounterIncrement() {
        mutexCounter.increment();
    }

    @Benchmark
    @Group("mutexCounter")
    @GroupThreads(4)
    public void testMutexCounterGetValue() {
        mutexCounter.getValue();
    }

    @Benchmark
    @Group("lockCounter")
    @GroupThreads(3)
    public void testLockCounterIncrement() {
        lockCounter.increment();
    }

    @Benchmark
    @Group("lockCounter")
    @GroupThreads(2)
    public void testLockCounterGetValue() {
        lockCounter.getValue();
    }
}
