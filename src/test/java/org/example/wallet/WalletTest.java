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

            wallet.add(10, Currency.INR);

            assertEquals(10, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_20_INRAfterAdding_20_INR() {
            Wallet wallet = new Wallet(Currency.INR);

            wallet.add(20, Currency.INR);

            assertEquals(20, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_30_INRAfterAdding_10_INRToExisting_20_INRBalance() {
            Wallet wallet = new Wallet(Currency.INR);
            wallet.add(20, Currency.INR);

            wallet.add(10, Currency.INR);

            assertEquals(30, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_2_INRAfterAdding_1_USD() {
            Wallet wallet = new Wallet(Currency.INR);

            wallet.add(1, Currency.USD);

            assertEquals(2, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_4_INRAfterAdding_2_USD() {
            Wallet wallet = new Wallet(Currency.INR);

            wallet.add(2, Currency.USD);

            assertEquals(4, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_6_INRAfterAdding_2_USDToExisting_2_INRBalance() {
            Wallet wallet = new Wallet(Currency.INR);
            wallet.add(2, Currency.INR);

            wallet.add(2, Currency.USD);

            assertEquals(6, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_4_INRAfterAdding_1_EUR() {
            Wallet wallet = new Wallet(Currency.INR);

            wallet.add(1, Currency.EUR);

            assertEquals(4, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_8_INRAfterAdding_2_EUR() {
            Wallet wallet = new Wallet(Currency.INR);

            wallet.add(2, Currency.EUR);

            assertEquals(8, wallet.getBalance());
        }
    }

    @Nested
    class USD {
        @Test
        void balanceShouldBe_10_USDAfterAdding_10_USD() {
            Wallet wallet = new Wallet(Currency.USD);

            wallet.add(10, Currency.USD);

            assertEquals(10, wallet.getBalance());
        }
        
        @Test
        void balanceShouldBe_1_USDAfterAdding_2_INR() {
            Wallet wallet = new Wallet(Currency.USD);

            wallet.add(2, Currency.INR);

            assertEquals(1, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_2_USDAfterAdding_4_INR() {
            Wallet wallet = new Wallet(Currency.USD);

            wallet.add(4, Currency.INR);

            assertEquals(2, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_2_USDAfterAdding_1_EUR() {
            Wallet wallet = new Wallet(Currency.USD);

            wallet.add(1, Currency.EUR);

            assertEquals(2, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_4_USDAfterAdding_2_EUR() {
            Wallet wallet = new Wallet(Currency.USD);

            wallet.add(2, Currency.EUR);

            assertEquals(4, wallet.getBalance());
        }
    }

    @Nested
    class EUR {
        @Test
        void balanceShouldBe_10_EURAfterAdding_10_EUR() {
            Wallet wallet = new Wallet(Currency.EUR);

            wallet.add(10, Currency.EUR);

            assertEquals(10, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_30_EURAfterAdding_20_EURToExisting_10_EURBalance() {
            Wallet wallet = new Wallet(Currency.EUR);
            wallet.add(10, Currency.EUR);

            wallet.add(20, Currency.EUR);

            assertEquals(30, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_1_EURAfterAdding_2_USD() {
            Wallet wallet = new Wallet(Currency.EUR);

            wallet.add(2, Currency.USD);

            assertEquals(1, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_2_EURAfterAdding_4_USD() {
            Wallet wallet = new Wallet(Currency.EUR);

            wallet.add(4, Currency.USD);

            assertEquals(2, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_1_EURAfterAdding_4_INR() {
            Wallet wallet = new Wallet(Currency.EUR);

            wallet.add(4, Currency.INR);

            assertEquals(1, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_2_EURAfterAdding_8_INR() {
            Wallet wallet = new Wallet(Currency.EUR);

            wallet.add(8, Currency.INR);

            assertEquals(2, wallet.getBalance());
        }

        @Test
        void balanceShouldBe_4_EURAfterAdding_8_INRToExisting_2_EUR() {
            Wallet wallet = new Wallet(Currency.EUR);
            wallet.add(4, Currency.USD);

            wallet.add(8, Currency.INR);

            assertEquals(4, wallet.getBalance());
        }
    }
}