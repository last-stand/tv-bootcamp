package org.example.wallet;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Nested
    class INR {
        @Test
        void balanceShouldBe_10_INRAfterAdding_10_INR() {
            Wallet wallet = new Wallet(Currency.INR);
            Money inr10 = new Money(10, Currency.INR);

            wallet.deposit(inr10);

            assertEquals(inr10, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_20_INRAfterAdding_20_INR() {
            Wallet wallet = new Wallet(Currency.INR);
            Money inr20 = new Money(20, Currency.INR);

            wallet.deposit(inr20);

            assertEquals(inr20, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_30_INRAfterAdding_10_INRToExisting_20_INRBalance() {
            Wallet wallet = new Wallet(Currency.INR);
            wallet.deposit(new Money(20, Currency.INR));

            wallet.deposit(new Money(10, Currency.INR));

            assertEquals(new Money(30, Currency.INR), wallet.getBalance());
        }

        @Test
        void balanceShouldBe_2_INRAfterAdding_1_USD() {
            Wallet wallet = new Wallet(Currency.INR);

            wallet.deposit(new Money(1, Currency.USD));

            assertEquals(new Money(2, Currency.INR), wallet.getBalance());
        }

        @Test
        void balanceShouldBe_4_INRAfterAdding_2_USD() {
            Wallet wallet = new Wallet(Currency.INR);

            wallet.deposit(new Money(2, Currency.USD));

            assertEquals(new Money(4, Currency.INR), wallet.getBalance());
        }

        @Test
        void balanceShouldBe_6_INRAfterAdding_2_USDToExisting_2_INRBalance() {
            Wallet wallet = new Wallet(Currency.INR);
            wallet.deposit(new Money(2, Currency.INR));

            wallet.deposit(new Money(2, Currency.USD));

            assertEquals(new Money(6, Currency.INR), wallet.getBalance());
        }

        @Test
        void balanceShouldBe_4_INRAfterAdding_1_EUR() {
            Wallet wallet = new Wallet(Currency.INR);

            wallet.deposit(new Money(1, Currency.EUR));

            assertEquals(new Money(4, Currency.INR), wallet.getBalance());
        }

        @Test
        void balanceShouldBe_8_INRAfterAdding_2_EUR() {
            Wallet wallet = new Wallet(Currency.INR);

            wallet.deposit(new Money(2, Currency.EUR));

            assertEquals(new Money(8, Currency.INR), wallet.getBalance());
        }
    }

    @Nested
    class USD {
        @Test
        void balanceShouldBe_10_USDAfterAdding_10_USD() {
            Wallet wallet = new Wallet(Currency.USD);
            Money usd10 = new Money(10, Currency.USD);

            wallet.deposit(usd10);

            assertEquals(usd10, wallet.getBalance());
        }
        
        @Test
        void balanceShouldBe_1_USDAfterAdding_2_INR() {
            Wallet wallet = new Wallet(Currency.USD);

            wallet.deposit(new Money(2, Currency.INR));

            assertEquals(new Money(1, Currency.USD), wallet.getBalance());
        }

        @Test
        void balanceShouldBe_2_USDAfterAdding_4_INR() {
            Wallet wallet = new Wallet(Currency.USD);

            wallet.deposit(new Money(4, Currency.INR));

            assertEquals(new Money(2, Currency.USD), wallet.getBalance());
        }

        @Test
        void balanceShouldBe_2_USDAfterAdding_1_EUR() {
            Wallet wallet = new Wallet(Currency.USD);

            wallet.deposit(new Money(1, Currency.EUR));

            assertEquals(new Money(2, Currency.USD), wallet.getBalance());
        }

        @Test
        void balanceShouldBe_4_USDAfterAdding_2_EUR() {
            Wallet wallet = new Wallet(Currency.USD);

            wallet.deposit(new Money(2, Currency.EUR));

            assertEquals(new Money(4, Currency.USD), wallet.getBalance());
        }
    }

    @Nested
    class EUR {
        @Test
        void balanceShouldBe_10_EURAfterAdding_10_EUR() {
            Wallet wallet = new Wallet(Currency.EUR);
            Money eur10 = new Money(10, Currency.EUR);

            wallet.deposit(eur10);

            assertEquals(eur10, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_30_EURAfterAdding_20_EURToExisting_10_EURBalance() {
            Wallet wallet = new Wallet(Currency.EUR);
            wallet.deposit(new Money(10, Currency.EUR));

            wallet.deposit(new Money(20, Currency.EUR));

            assertEquals(new Money(30, Currency.EUR), wallet.getBalance());
        }

        @Test
        void balanceShouldBe_1_EURAfterAdding_2_USD() {
            Wallet wallet = new Wallet(Currency.EUR);

            wallet.deposit(new Money(2, Currency.USD));

            assertEquals(new Money(1, Currency.EUR), wallet.getBalance());
        }

        @Test
        void balanceShouldBe_2_EURAfterAdding_4_USD() {
            Wallet wallet = new Wallet(Currency.EUR);

            wallet.deposit(new Money(4, Currency.USD));

            assertEquals(new Money(2, Currency.EUR), wallet.getBalance());
        }

        @Test
        void balanceShouldBe_1_EURAfterAdding_4_INR() {
            Wallet wallet = new Wallet(Currency.EUR);

            wallet.deposit(new Money(4, Currency.INR));

            assertEquals(new Money(1, Currency.EUR), wallet.getBalance());
        }

        @Test
        void balanceShouldBe_2_EURAfterAdding_8_INR() {
            Wallet wallet = new Wallet(Currency.EUR);

            wallet.deposit(new Money(8, Currency.INR));

            assertEquals(new Money(2, Currency.EUR), wallet.getBalance());
        }

        @Test
        void balanceShouldBe_4_EURAfterAdding_8_INRToExisting_2_EUR() {
            Wallet wallet = new Wallet(Currency.EUR);
            wallet.deposit(new Money(4, Currency.USD));

            wallet.deposit(new Money(8, Currency.INR));

            assertEquals(new Money(4, Currency.EUR), wallet.getBalance());
        }
    }
}