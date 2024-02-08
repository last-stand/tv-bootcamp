package org.example.wallet;

public class Currency {
    public static final Currency INR = new Currency(1);
    public static final Currency USD = new Currency(2);
    public static final Currency EUR = new Currency(4);
    private final int conversionRate;

    private Currency(int conversionRate) {
        this.conversionRate = conversionRate;
    }

    public int convertTo(int amount, Currency other) {
        int inrValue = toINR(amount, other);
        return fromINR(inrValue);
    }

    private int fromINR(int inrValue) {
        return inrValue / conversionRate;
    }

    private static int toINR(int amount, Currency other) {
        return amount * other.conversionRate;
    }
}
