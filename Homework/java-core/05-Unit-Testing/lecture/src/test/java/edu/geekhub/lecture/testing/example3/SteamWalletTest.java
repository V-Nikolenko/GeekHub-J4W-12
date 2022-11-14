package edu.geekhub.lecture.testing.example3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SteamWalletTest {

    private SteamWallet steamWallet;

    @BeforeEach
    public void create_steam_wallet() {
        steamWallet = new SteamWallet("Gamer Nickname");
    }

    @Test
    void initial_balance_in_not_positive() {
        assertFalse(steamWallet.hasPositiveBalance());
    }

    @Test
    void has_positive_balance() {
        steamWallet.deposit(50);
        assertTrue(steamWallet.hasPositiveBalance());
    }

    @Test
    void deposit_increases_balance() {
        int initialBalance = steamWallet.getBalance();
        steamWallet.deposit(100);

        assertTrue(
            steamWallet.getBalance() > initialBalance,
            "Balance should be positive after money deposit"
        );
    }

    @Test
    void withdraw_decrease_balance() throws WithdrawException {
        steamWallet.deposit(100);

        steamWallet.withdraw(50);

        assertEquals(50, steamWallet.getBalance());
    }

    @Test
    void check_that_wallets_with_same_name_but_different_balance_are_not_equal() {
        var wallet1 = new SteamWallet("wallet");
        var wallet2 = new SteamWallet("wallet");

        wallet1.deposit(1);
        wallet2.deposit(2);

        assertNotEquals(wallet2, wallet1);
    }

    @Test
    void withdraw_more_money_than_in_wallet_rejected() {
        steamWallet.deposit(100);

        assertThrowsExactly(
            WithdrawException.class,
            () -> steamWallet.withdraw(200)
        );
    }

    @Test
    void withdraw_enough_money_than_in_wallet() {
        steamWallet.deposit(100);

        assertDoesNotThrow(() -> steamWallet.withdraw(50));
    }

}
