package edu.geekhub.lecture.testing.example3;

import java.util.Objects;

public class SteamWallet {

    private final String nickname;
    private int balance;

    public SteamWallet(String nickname) {
        this.nickname = nickname;
        this.balance = 0;
    }

    boolean hasPositiveBalance() {
        return balance > 0;
    }

    void deposit(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }

        balance += money;
    }

    void withdraw(int money) throws WithdrawException {
        if (money > balance) {
            throw new WithdrawException(
                String.format(
                    "Not enough money: %d to withdraw %d",
                    balance,
                    money
                )
            );
        }

        balance -= money;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SteamWallet that = (SteamWallet) o;
        return balance == that.balance && Objects.equals(nickname, that.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, balance);
    }
}
