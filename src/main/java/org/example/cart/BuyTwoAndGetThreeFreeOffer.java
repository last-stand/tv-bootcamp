package org.example.cart;

public class BuyTwoAndGetThreeFreeOffer implements Offer{
    @Override
    public double calculateOfferedPrice(int quantity, double price) {
        int minimumQuantityToAvailOffer = 3;
        if (quantity >= minimumQuantityToAvailOffer) {
            return 2 * price;
        }
        return quantity * price;
    }
}
