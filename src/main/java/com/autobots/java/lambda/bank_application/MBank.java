package com.autobots.java.lambda.bank_application;

public class MBank extends BankBase {

    private double balance = 200;

    public MBank (long accountNumber, long routingNumber) throws Exception {
        super(accountNumber, routingNumber);
        addToBankRecords(this); // добавь в эту базу этого человека
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount > 200000) {
            throw new IllegalArgumentException("invalid amount. it cannot be deposit");
        } else {
            balance += amount;
        }
    }

    @Override
    public void withDraw(double amount) {
        if (amount < 0 || amount > 150000) {
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
