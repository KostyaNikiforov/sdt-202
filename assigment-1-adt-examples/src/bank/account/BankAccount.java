package bank.account;

/** Bank account ADT: deposit, withdraw, inspect balance. */
public interface BankAccount {
    /** Add amount. amount > 0. */
    void deposit(double amount);

    /** Subtract amount. amount > 0 and amount <= balance. */
    void withdraw(double amount);

    /** Current balance. */
    double balance();
}
