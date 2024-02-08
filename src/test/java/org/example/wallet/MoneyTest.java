package org.example.wallet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("Difference should be -1")
    void differenceShouldBeLessThanZeroWhenComparing_1_INRWith_2_INR() {
        Money inr1 = new Money(1, Currency.INR);
        Money inr2 = new Money(2, Currency.INR);

        int difference = inr1.compareTo(inr2);

        assertEquals(-1, difference);
    }

    @Test
    @DisplayName("Difference should be 1")
    void differenceShouldBeGreaterThanZeroWhenComparing_2_INRWith_1_INR() {
        Money inr1 = new Money(1, Currency.INR);
        Money inr2 = new Money(2, Currency.INR);

        int difference = inr2.compareTo(inr1);

        assertEquals(1, difference);
    }

    @Test
    @DisplayName("Difference should be 0")
    void differenceShouldBeZeroWhenComparing_1_INRWith_1_INR() {
        Money inr1 = new Money(1, Currency.INR);
        Money otherInr1 = new Money(1, Currency.INR);

        int difference = inr1.compareTo(otherInr1);

        assertEquals(0, difference);
    }

    @Test
    @DisplayName("Difference should be -1")
    void differenceShouldBeLessThanZeroWhenComparing_1_USDWith_1_EUR() {
        Money usd1 = new Money(1, Currency.USD);
        Money eur1 = new Money(1, Currency.EUR);

        int difference = usd1.compareTo(eur1);

        assertEquals(-1, difference);
    }
}