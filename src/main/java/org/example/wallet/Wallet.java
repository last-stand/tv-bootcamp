package org.example.wallet;

public class Wallet {
    private Money balance;

    public Wallet(Currency currency) {
        this.balance = new Money(0, currency);
    }

    public void deposit(Money money) {
        this.balance = balance.add(money);
    }

    //TODO: deduct money

    public Money getBalance() {
        return this.balance;
    }
}
