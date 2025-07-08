package com.autobots.java.lambda.bank_application;

public interface Bank {

    double getBalance (); // пополняет баланс
    void deposit (double amount); // пополняет счет
    void withDraw (double amount); // снять деньги

    static void transferFunds (Bank sender, Bank recipient, double transferAmount) {
        // межбанковские переводы, типо отправлять с одного банка на другой

        sender.withDraw(transferAmount);
        recipient.deposit(transferAmount);

    }
}
