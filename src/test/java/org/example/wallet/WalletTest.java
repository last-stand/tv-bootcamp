package org.example.wallet;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

        @Nested
        class BHT {
            @Test
            void balanceShouldBe_10_BHTAfterAdding_10_BHT() {
                Wallet wallet = new Wallet(Currency.BHT);
                Money bht10 = new Money(10, Currency.BHT);

                wallet.deposit(bht10);

                assertEquals(bht10, wallet.getBalance());
            }
        }

        @Nested
        class Sort {
            @Test
            void shouldSortINRWalletsIntoAscendingOrder() {
                List<Wallet> walletList = new ArrayList<>();
                Money inr20 = new Money(20, Currency.INR);
                Wallet inr20Wallet = new Wallet(Currency.INR);
                inr20Wallet.deposit(inr20);
                Money inr5 = new Money(5, Currency.INR);
                Wallet inr5Wallet = new Wallet(Currency.INR);
                inr5Wallet.deposit(inr5);
                Money inr10 = new Money(10, Currency.INR);
                Wallet inr10Wallet = new Wallet(Currency.INR);
                inr10Wallet.deposit(inr10);
                walletList.add(inr20Wallet);
                walletList.add(inr5Wallet);
                walletList.add(inr10Wallet);

                List<Wallet> sortedWallets = Wallet.sort(walletList, "ASC");

                assertEquals(List.of(inr5Wallet, inr10Wallet, inr20Wallet), sortedWallets);
            }

            @Test
            void shouldSortWalletsHavingUSD_EUR_BHTIntoAscendingOrder() {
                List<Wallet> walletList = new ArrayList<>();
                Money usd1 = new Money(1, Currency.USD);
                Wallet usd1Wallet = new Wallet(Currency.USD);
                usd1Wallet.deposit(usd1);
                Money bht1 = new Money(5, Currency.BHT);
                Wallet bht1Wallet = new Wallet(Currency.BHT);
                bht1Wallet.deposit(bht1);
                Money eur1 = new Money(10, Currency.EUR);
                Wallet eur1Wallet = new Wallet(Currency.EUR);
                eur1Wallet.deposit(eur1);
                walletList.add(usd1Wallet);
                walletList.add(bht1Wallet);
                walletList.add(eur1Wallet);

                List<Wallet> sortedWallets = Wallet.sort(walletList, "ASC");

                assertEquals(List.of(bht1Wallet, usd1Wallet, eur1Wallet), sortedWallets);
            }

            @Test
            void shouldSortINRWalletsIntoDescendingOrder() {
                List<Wallet> walletList = new ArrayList<>();
                Money inr20 = new Money(20, Currency.INR);
                Wallet inr20Wallet = new Wallet(Currency.INR);
                inr20Wallet.deposit(inr20);
                Money inr5 = new Money(5, Currency.INR);
                Wallet inr5Wallet = new Wallet(Currency.INR);
                inr5Wallet.deposit(inr5);
                Money inr10 = new Money(10, Currency.INR);
                Wallet inr10Wallet = new Wallet(Currency.INR);
                inr10Wallet.deposit(inr10);
                walletList.add(inr20Wallet);
                walletList.add(inr5Wallet);
                walletList.add(inr10Wallet);

                List<Wallet> sortedWallets = Wallet.sort(walletList, "DESC");

                assertEquals(List.of(inr20Wallet, inr10Wallet, inr5Wallet), sortedWallets);
            }

            @Test
            void shouldSortWalletsHavingUSD_EUR_BHTIntoDescendingOrder() {
                List<Wallet> walletList = new ArrayList<>();
                Money usd1 = new Money(1, Currency.USD);
                Wallet usd1Wallet = new Wallet(Currency.USD);
                usd1Wallet.deposit(usd1);
                Money bht1 = new Money(5, Currency.BHT);
                Wallet bht1Wallet = new Wallet(Currency.BHT);
                bht1Wallet.deposit(bht1);
                Money eur1 = new Money(10, Currency.EUR);
                Wallet eur1Wallet = new Wallet(Currency.EUR);
                eur1Wallet.deposit(eur1);
                walletList.add(usd1Wallet);
                walletList.add(bht1Wallet);
                walletList.add(eur1Wallet);

                List<Wallet> sortedWallets = Wallet.sort(walletList, "DESC");

                assertEquals(List.of(eur1Wallet, usd1Wallet, bht1Wallet), sortedWallets);
            }
        }
    }
}