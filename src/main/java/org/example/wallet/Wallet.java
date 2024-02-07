package org.example.wallet;

public class Wallet {
    private Money balance;

    public Wallet(Currency currency) {
        this.balance = new Money(0, currency);
    }

    public void deposit(Money money) {
        int convertedAmount = getConvertedAmount(money.getAmount(), money.getCurrency());
        this.balance = new Money(this.balance.getAmount() + convertedAmount, this.balance.getCurrency());
    }

    private int getConvertedAmount(int amount, Currency currency) {
        if (this.balance.getCurrency().equals(currency)) {
            return amount;
        }
        if (this.balance.getCurrency().equals(Currency.USD)) {
            if (currency.equals(Currency.INR)) {
                return amount / 2;
            } else if (currency.equals(Currency.EUR)) {
                return amount * 2;
            }
        } else if (this.balance.getCurrency().equals(Currency.INR)) {
            if (currency.equals(Currency.USD)) {
                return amount * 2;
            } else if (currency.equals(Currency.EUR)) {
                return amount * 4;
            }
        } else {
            if (currency.equals(Currency.INR)) {
                return amount / 4;
            } else if (currency.equals(Currency.USD)) {
                return amount / 2;
            }
        }
        return amount;
    }

    //TODO: deduct money

    public Money getBalance() {
        return this.balance;
    }
}
