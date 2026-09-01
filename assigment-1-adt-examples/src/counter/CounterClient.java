package counter;

public class CounterClient {
    public static void main(String[] args) {
        Counter c = new CounterImpl();
        c.increment();
        c.increment();
        System.out.println(c.value());
        System.out.println(c);
    }
}
