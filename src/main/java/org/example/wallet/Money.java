package org.example.wallet;

import java.util.Objects;

public class Money {
    private final int amount;
    private final Currency currency;

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    Money add(Money other) {
        int convertedAmount = 0;
        int amount = other.amount;
        Currency currency = other.currency;
        if (this.currency.equals(currency)) {
            convertedAmount = amount;
        } else {
            convertedAmount = convertTo(amount, currency);
        }
        return new Money(getAmount() + convertedAmount, this.currency);
    }

    private int convertTo(int amount, Currency currency) {
        int inrValue = amount * currency.getConversionRate();
        return inrValue / this.currency.getConversionRate();
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
}
