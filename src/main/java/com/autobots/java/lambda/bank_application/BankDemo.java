package com.autobots.java.lambda.bank_application;

public class BankDemo {
    public static void main(String[] args) throws Exception {

        MBank inuaMBank = new MBank(123456789111L, 999999999);
        System.out.println(inuaMBank.getBalance());
        inuaMBank.deposit(100000);
        System.out.println("-------");
        System.out.println(inuaMBank.getBalance());

        Optima inuaOptims = new Optima(123456789112L, 333333333);
        System.out.println(inuaOptims.getBalance());

        System.out.println("--------");

        Bank.transferFunds(inuaMBank, inuaOptims, 500);
        System.out.println(inuaMBank.getBalance());
        System.out.println(inuaOptims.getBalance());

        System.out.println("--------");

        Demir zinaidaDemir = new Demir(123456789122L, 888888888);
//        Bank.transferFunds(zinaidaDemir, inuaOptims, 1000);
        System.out.println(zinaidaDemir.getBalance());

        BankBase.bankRecords.stream().filter(n -> n.getBalance() > 100).forEach(System.out::println);

        double allSumOfBanks = BankBase.bankRecords.stream().mapToDouble(Bank::getBalance).sum();
        System.out.println(allSumOfBanks);
    }
}
