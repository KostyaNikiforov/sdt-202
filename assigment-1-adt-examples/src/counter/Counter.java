package counter;

/** Counter ADT: starts at 0, can only go up by 1. */
public interface Counter {
    /** Add 1. */
    void increment();

    /** Current count. */
    int value();

    String toString();
}
