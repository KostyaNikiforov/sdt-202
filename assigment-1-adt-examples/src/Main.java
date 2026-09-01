import bank.account.BankAccountClient;
import counter.CounterClient;

public class Main {
    public static void main(String[] args) {
        CounterClient.main(args);
        BankAccountClient.main(args);
        FibonacciTrace.main(args);
    }
}
