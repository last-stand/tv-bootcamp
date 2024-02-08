package org.example.wallet;

import java.util.Comparator;
import java.util.List;

public class Wallet {
    private Money balance;

    public Wallet(Currency currency) {
        this.balance = new Money(0, currency);
    }

    public void deposit(Money money) {
        this.balance = balance.add(money);
    }

    public static List<Wallet> sort(List<Wallet> walletList, String order) {
        List<Wallet> ascSortedWalletlist = walletList.stream().sorted(Comparator.comparing(wallet -> wallet.balance)).toList();
        if (order.equals("DESC")) {
            return ascSortedWalletlist.reversed();
        }
        return ascSortedWalletlist;
    }

    //TODO: deduct money

    public Money getBalance() {
        return this.balance;
    }
}
