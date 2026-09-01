package bank.account;

public class BankAccountClient {
    public static void main(String[] args) {
        BankAccount a = new BankAccountImpl();
        a.deposit(100);
        a.withdraw(40);
        System.out.println(a.balance());
    }
}
