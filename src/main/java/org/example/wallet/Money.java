package org.example.wallet;

import java.util.Objects;

public class Money {
    private final int amount;
    private final Currency currency;

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    Money add(Money other) {
        int convertedAmount = 0;
        int amount = other.amount;
        Currency currency = other.currency;
        if (this.currency.equals(currency)) {
            convertedAmount = amount;
        } else {
            if (this.currency.equals(Currency.USD)) {
                if (currency.equals(Currency.INR)) {
                    convertedAmount = amount / 2;
                } else if (currency.equals(Currency.EUR)) {
                    convertedAmount = amount * 2;
                }
            } else if (this.currency.equals(Currency.INR)) {
                if (currency.equals(Currency.USD)) {
                    convertedAmount = amount * 2;
                } else if (currency.equals(Currency.EUR)) {
                    convertedAmount = amount * 4;
                }
            } else { if (currency.equals(Currency.INR)) {
                convertedAmount = amount / 4;
            } else if (currency.equals(Currency.USD)) {
                convertedAmount = amount / 2;
            }
            }
        }
        return new Money(getAmount() + convertedAmount, this.currency);
    }
}
