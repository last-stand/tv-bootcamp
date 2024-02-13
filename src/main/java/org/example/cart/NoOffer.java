package org.example.cart;

public class NoOffer implements Offer {
    @Override
    public double calculateOfferedPrice(int quantity, double price) {
        return quantity * price;
    }
}
