package org.example.wallet;

import java.util.Objects;

public class Money implements Comparable<Money> {
    private final int amount;
    private final Currency currency;

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money add(Money other) {
        return new Money(this.amount + currency.convertTo(other.amount, other.currency), this.currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount && Objects.equals(currency, money.currency);
    }

    @Override
    public int compareTo(Money other) {
        int convertedAmount = currency.convertTo(other.amount, other.currency);
        return Integer.compare(amount, convertedAmount);
    }
}
