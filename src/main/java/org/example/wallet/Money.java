package org.example.wallet;

import java.util.Objects;

public class Money {
    private final int amount;
    private final Currency currency;

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money add(Money other) {
        return new Money(this.amount + convertTo(other.amount, other.currency), this.currency);
    }

    private int convertTo(int amount, Currency currency) {
        int inrValue = amount * currency.getConversionRate();
        return inrValue / this.currency.getConversionRate();
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
}
