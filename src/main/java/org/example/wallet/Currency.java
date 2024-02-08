package org.example.wallet;

public class Currency {
    public static final Currency BHT = new Currency(1);
    public static final Currency INR = new Currency(3 * BHT.conversionRate);
    public static final Currency USD = new Currency(2 * INR.conversionRate);
    public static final Currency EUR = new Currency(4 * INR.conversionRate);
    private final int conversionRate;

    private Currency(int conversionRate) {
        this.conversionRate = conversionRate;
    }

    public int convertTo(int amount, Currency other) {
        int baseValue = toBase(amount, other);
        return fromBase(baseValue);
    }

    private int fromBase(int baseValue) {
        return baseValue / conversionRate;
    }

    private static int toBase(int amount, Currency other) {
        return amount * other.conversionRate;
    }
}
