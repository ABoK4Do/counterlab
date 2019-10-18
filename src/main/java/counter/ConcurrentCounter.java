package counter;

import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentCounter implements Counter {
    private AtomicLong value = new AtomicLong(0);

    @Override
    public void increment() {
        value.incrementAndGet();
    }

    @Override
    public long getValue() {
        return value.get();
    }
}
