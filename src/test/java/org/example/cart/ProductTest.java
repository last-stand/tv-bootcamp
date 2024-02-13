package org.example.cart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void priceShouldBe_5_IfNullIsPassedAsOffer() {
        Product banana = new Product("Banana", 5);

        banana.applyOffer(null);

        assertEquals(5, banana.getOfferedPrice(1));
    }
}