package org.example.wallet;

public class Currency {
    public static final Currency INR = new Currency(1);
    public static final Currency USD = new Currency(2);
    public static final Currency EUR = new Currency(4);
    public Currency(int conversionRate) {
    }
}
