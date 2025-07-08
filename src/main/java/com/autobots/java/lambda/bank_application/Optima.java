package com.autobots.java.lambda.bank_application;

public class Optima extends BankBase {

    private double balance = 0;

    public Optima(long accountNumber, long routingNumber) throws Exception {
        super(accountNumber, routingNumber);
        addToBankRecords(this);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount > 300000) {
            throw new IllegalArgumentException("invalid amount. it cannot be deposit");
        } else {
            balance += amount;
        }
    }

    @Override
    public void withDraw(double amount) {
        if (amount < 0 || amount > 250000) {
            throw new IllegalArgumentException("invalid amount. it cannot be withdraw");
        } else {
            if (balance < amount) {
                throw new IllegalArgumentException("insufficient balance");
            } else {
                balance -= amount;
            }
        }
    }
}
