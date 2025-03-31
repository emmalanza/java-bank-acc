package com.emma.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

    @Test
    void testWithdrawCreatesOverdraft() {
        CurrentAccount account = new CurrentAccount(5000, 5);
        account.withdraw(6000);
        assertEquals(0, account.balance);
        assertEquals(1000, account.getOverdraft());
    }

    @Test
    void testDepositReducesOverdraft() {
        CurrentAccount account = new CurrentAccount(5000, 5);
        account.withdraw(6000);
        account.deposit(1000);
        assertEquals(0, account.balance);
        assertEquals(0, account.getOverdraft());
    }
    
}
