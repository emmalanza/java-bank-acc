package com.emma.models;

public class SavingAccount extends Account {

    private boolean active;

    public SavingAccount(double balance, double annualRate) {
        super(balance, annualRate);
        this.active = balance>= 10000;

    }

    @Override
    public void deposit(double amount) {
        if (active) {
            super.deposit(amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (active) {
            super.withdraw(amount);
        }
    }
    
}
