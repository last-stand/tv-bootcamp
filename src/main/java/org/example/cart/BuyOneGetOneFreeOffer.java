package org.example.cart;

public class BuyOneGetOneFreeOffer implements Offer{
    @Override
    public double calculateOfferedPrice(int quantity, double price) {
        int minimumQuantityToAvailOffer = 2;
        int quantityForPricing = quantity / minimumQuantityToAvailOffer + quantity % minimumQuantityToAvailOffer;
        return quantityForPricing * price;
    }
}
