package com.emma.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    void testPrint() {
        CurrentAccount account = new CurrentAccount(15000, 12);
        account.withdraw(2000);
        account.deposit(1000);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        account.print();

        String expectedOutput = "Balance: 14000.0\n" +
                "Monthly Fee: 0.0\n" +
                "Total transactions: 2\n" +
                "Overdraft: 0.0\n";

        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }
    
}
