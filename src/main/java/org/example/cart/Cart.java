package org.example.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> itemList = new ArrayList<>();

    public void add(CartItem cartItem) {
        itemList.add(cartItem);
    }

    public double getTotal() {
        return itemList.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    //TODO: If same item added twice update the item quantity
}
