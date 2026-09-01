package bank.account;

import bank.account.BankAccount;

public class BankAccountImpl implements BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount must be > 0");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) throw new IllegalArgumentException("invalid withdraw");
        balance -= amount;
    }

    public double balance() {
        return balance;
    }
}
