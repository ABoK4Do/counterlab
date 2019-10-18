package counter;

public class MutexCounter implements Counter {
    private long value;

    @Override
    synchronized public void increment() {
        value++;
    }

    @Override
    synchronized public long getValue() {
        return value;
    }
}
