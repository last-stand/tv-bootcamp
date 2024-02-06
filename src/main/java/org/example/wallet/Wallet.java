package org.example.wallet;

public class Wallet {
    private final Currency currency;
    private int balance = 0;

    public Wallet(Currency currency) {
        this.currency = currency;
    }

    public void add(int amount, Currency currency) {
        if (this.currency.equals(currency)) {
            this.balance += amount;
            return;
        }
        handleDifferentCurrency(amount, currency);
    }

    private void handleDifferentCurrency(int amount, Currency currency) {
        if (this.currency.equals(Currency.USD)) {
            if (currency.equals(Currency.INR)) {
                this.balance += amount / 2;
            } else if (currency.equals(Currency.EUR)) {
                this.balance += amount * 2;
            }
        } else if (this.currency.equals(Currency.INR)) {
            if (currency.equals(Currency.USD)) {
                this.balance += amount * 2;
            } else if (currency.equals(Currency.EUR)) {
                this.balance += amount * 4;
            }
        } else {
            if (currency.equals(Currency.INR)) {
                this.balance += amount / 4;
            } else if (currency.equals(Currency.USD)) {
                this.balance += amount / 2;
            }
        }
    }

    //TODO: deduct money

    public int getBalance() {
        return this.balance;
    }
}
