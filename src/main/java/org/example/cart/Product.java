package org.example.cart;

public class Product {
    private final String name;
    private final double price;
    private Offer offer;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.offer = new NoOffer();
    }

    public void applyOffer(Offer offer) {
        if (offer != null) {
            this.offer = offer;
        }
    }

    public double getOfferedPrice(int quantity) {
        return offer.calculateOfferedPrice(quantity, this.price);
    }

}
