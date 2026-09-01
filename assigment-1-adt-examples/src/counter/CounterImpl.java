package counter;

public class CounterImpl implements Counter {
    private int count;

    public void increment() {
        count++;
    }

    public int value() {
        return count;
    }

    public String toString() {
        return "Counter(" + count + ")";
    }
}
