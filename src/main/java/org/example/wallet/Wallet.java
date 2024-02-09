package org.example.wallet;

import java.util.Comparator;
import java.util.List;

public class Wallet {
    public static final Comparator<Wallet> ASC_ORDER_COMPARATOR = Comparator.comparing(wallet -> wallet.balance);
    public static final Comparator<Wallet> DESC_ORDER_COMPARATOR = ASC_ORDER_COMPARATOR.reversed();
    private Money balance;

    public Wallet(Currency currency) {
        this.balance = new Money(0, currency);
    }

    public void deposit(Money money) {
        this.balance = balance.add(money);
    }

    public static List<Wallet> sort(List<Wallet> walletList, Comparator<Wallet> comparator) {
        return walletList.stream().sorted(comparator).toList();
    }

    //TODO: deduct money

    public Money getBalance() {
        return this.balance;
    }
}
