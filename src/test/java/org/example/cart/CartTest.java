package org.example.cart;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    @Test
    void totalShouldBe_10_WhenAppleItemOfPrice_10_AddedToTheCart() {
        Cart cart = new Cart();
        Product apple = new Product("Apple", 10);
        CartItem item = new CartItem(apple, 1);

        cart.add(item);

        assertEquals(10, cart.getTotal());
    }

    @Test
    void totalShouldBe_20_WhenAppleItemOfPrice_20_AddedToTheCart() {
        Cart cart = new Cart();
        Product apple = new Product("Apple", 20);
        CartItem item = new CartItem(apple, 1);

        cart.add(item);

        assertEquals(20, cart.getTotal());
    }

    @Test
    void totalShouldBe_20_WhenAppleItemOfPrice_10_AddedToTheCartTwice() {
        Cart cart = new Cart();
        Product apple = new Product("Apple", 10);
        CartItem item = new CartItem(apple, 2);

        cart.add(item);

        assertEquals(20, cart.getTotal());
    }

    @Test
    void totalShouldBe_20_WhenOrangeItemOfPrice_20_AddedToTheCart() {
        Cart cart = new Cart();
        Product orange = new Product("Orange", 20);
        CartItem item = new CartItem(orange, 1);

        cart.add(item);

        assertEquals(20, cart.getTotal());
    }

    @Test
    void totalShouldBe_30_WhenOrangeItemOfPrice_20_AndAppleItemOfPrice_10_AreAddedToTheCart() {
        Cart cart = new Cart();
        Product orange = new Product("Orange", 20);
        Product apple = new Product("Apple", 10);
        CartItem orangeItem = new CartItem(orange, 1);
        CartItem appleItem = new CartItem(apple, 1);

        cart.add(orangeItem);
        cart.add(appleItem);

        assertEquals(30, cart.getTotal());
    }

    @Nested
    class BuyOneAndGetOneFreeOffer {
        @Test
        void totalShouldBe_10_WhenBuyOneGetOneFreeOfferIsAppliedOnQuantityOf_1_Apple() {
            Cart cart = new Cart();
            Product apple = new Product("Apple", 10);
            BuyOneGetOneFreeOffer buyOneGetOneFreeOffer = new BuyOneGetOneFreeOffer();
            apple.applyOffer(buyOneGetOneFreeOffer);
            CartItem appleItem = new CartItem(apple, 1);

            cart.add(appleItem);

            assertEquals(10, cart.getTotal());
        }

        @Test
        void totalShouldBe_10_WhenBuyOneGetOneFreeOfferIsAppliedOnQuantityOf_2_Apples() {
            Cart cart = new Cart();
            Product apple = new Product("Apple", 10);
            BuyOneGetOneFreeOffer buyOneGetOneFreeOffer = new BuyOneGetOneFreeOffer();
            apple.applyOffer(buyOneGetOneFreeOffer);
            CartItem appleItem = new CartItem(apple, 2);

            cart.add(appleItem);

            assertEquals(10, cart.getTotal());
        }

        @Test
        void totalShouldBe_20_WhenBuyOneGetOneFreeOfferIsAppliedOnQuantityOf_3_Apples() {
            Cart cart = new Cart();
            Product apple = new Product("Apple", 10);
            BuyOneGetOneFreeOffer buyOneGetOneFreeOffer = new BuyOneGetOneFreeOffer();
            apple.applyOffer(buyOneGetOneFreeOffer);
            CartItem appleItem = new CartItem(apple, 3);

            cart.add(appleItem);

            assertEquals(20, cart.getTotal());
        }

        @Test
        void totalShouldBe_20_WhenBuyOneGetOneFreeOfferIsAppliedOnQuantityOf_4_Apples() {
            Cart cart = new Cart();
            Product apple = new Product("Apple", 10);
            BuyOneGetOneFreeOffer buyOneGetOneFreeOffer = new BuyOneGetOneFreeOffer();
            apple.applyOffer(buyOneGetOneFreeOffer);
            CartItem appleItem = new CartItem(apple, 4);

            cart.add(appleItem);

            assertEquals(20, cart.getTotal());
        }
    }

    @Nested
    class BuyTwoGetThreeFreeOffer {
        @Test
        void totalShouldBe_20_WhenBuyTwoAndGetThreeFreeOfferIsAppliedOnQuantityOf_1_Orange() {
            Cart cart = new Cart();
            Product orange = new Product("Orange", 20);
            BuyTwoAndGetThreeFreeOffer buyTwoAndGetThreeFreeOffer = new BuyTwoAndGetThreeFreeOffer();
            orange.applyOffer(buyTwoAndGetThreeFreeOffer);
            CartItem orangeItem = new CartItem(orange, 1);

            cart.add(orangeItem);

            assertEquals(20, cart.getTotal());
        }

        @Test
        void totalShouldBe_40_WhenBuyTwoAndGetThreeFreeOfferIsAppliedOnQuantityOf_2_Oranges() {
            Cart cart = new Cart();
            Product orange = new Product("Orange", 20);
            BuyTwoAndGetThreeFreeOffer buyTwoAndGetThreeFreeOffer = new BuyTwoAndGetThreeFreeOffer();
            orange.applyOffer(buyTwoAndGetThreeFreeOffer);
            CartItem orangeItem = new CartItem(orange, 2);

            cart.add(orangeItem);

            assertEquals(40, cart.getTotal());
        }

        @Test
        void totalShouldBe_40_WhenBuyTwoAndGetThreeFreeOfferIsAppliedOnQuantityOf_3_Oranges() {
            Cart cart = new Cart();
            Product orange = new Product("Orange", 20);
            BuyTwoAndGetThreeFreeOffer buyTwoAndGetThreeFreeOffer = new BuyTwoAndGetThreeFreeOffer();
            orange.applyOffer(buyTwoAndGetThreeFreeOffer);
            CartItem orangeItem = new CartItem(orange, 3);

            cart.add(orangeItem);

            assertEquals(40, cart.getTotal());
        }

        @Test
        void totalShouldBe_40_WhenBuyTwoAndGetThreeFreeOfferIsAppliedOnQuantityOf_4_Oranges() {
            Cart cart = new Cart();
            Product orange = new Product("Orange", 20);
            BuyTwoAndGetThreeFreeOffer buyTwoAndGetThreeFreeOffer = new BuyTwoAndGetThreeFreeOffer();
            orange.applyOffer(buyTwoAndGetThreeFreeOffer);
            CartItem orangeItem = new CartItem(orange, 4);

            cart.add(orangeItem);

            assertEquals(40, cart.getTotal());
        }

        @Test
        void totalShouldBe_40_WhenBuyTwoAndGetThreeFreeOfferIsAppliedOnQuantityOf_5_Oranges() {
            Cart cart = new Cart();
            Product orange = new Product("Orange", 20);
            BuyTwoAndGetThreeFreeOffer buyTwoAndGetThreeFreeOffer = new BuyTwoAndGetThreeFreeOffer();
            orange.applyOffer(buyTwoAndGetThreeFreeOffer);
            CartItem orangeItem = new CartItem(orange, 5);

            cart.add(orangeItem);

            assertEquals(40, cart.getTotal());
        }

        @Test
        @Disabled
        void totalShouldBe_60_WhenBuyTwoAndGetThreeFreeOfferIsAppliedOnQuantityOf_6_Oranges() {
            Cart cart = new Cart();
            Product orange = new Product("Orange", 20);
            BuyTwoAndGetThreeFreeOffer buyTwoAndGetThreeFreeOffer = new BuyTwoAndGetThreeFreeOffer();
            orange.applyOffer(buyTwoAndGetThreeFreeOffer);
            CartItem orangeItem = new CartItem(orange, 6);

            cart.add(orangeItem);

            assertEquals(60, cart.getTotal());
        }
    }
}