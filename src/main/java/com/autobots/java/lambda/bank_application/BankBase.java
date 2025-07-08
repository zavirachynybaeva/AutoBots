package com.autobots.java.lambda.bank_application;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class BankBase implements Bank {

    // у каждого банка должен быть:
    private String bankName;
    private long accountNumber;
    private long routingNumber; // чтобы система знала на какой номер отправляем деньги

    // нам нужно хранилище, в которых будут храниться данные клиентов банка, которые не должны повторяться
    public static Set<BankBase> bankRecords = new HashSet<>();

    // переопределили 2 метода, чтобы работать с коллекциями,
    // чтобы хранилище работало корректно
    // чтобы они сравнивались не по ссылкам, а по значениям
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankBase bankBase = (BankBase) o;
        return accountNumber == bankBase.accountNumber && routingNumber == bankBase.routingNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, routingNumber);
    }

    @Override
    public String toString() {
        return "BankBase{" +
                "accountNumber=" + accountNumber +
                ", routingNumber=" + routingNumber +
                '}';
    }

    public BankBase(long accountNumber, long routingNumber) {

        if (Long.toString(accountNumber).length() != 12) {
            throw new IllegalArgumentException("account number must be 12 digits");
        } else if (Long.toString(routingNumber).length() != 9) {
            throw new IllegalArgumentException("routing number must be 9 digits");
        } else {
            this.accountNumber = accountNumber;
            this.routingNumber = routingNumber;
        }
    }

    // создаем метод, который будет добавлять новые данные в это хранилище
    public static void addToBankRecords (BankBase bank) throws Exception {

        for (BankBase bankBase : bankRecords) {
            if (bankBase.getAccountNumber() == bank.getAccountNumber()) {
                throw new Exception(bank.getAccountNumber() + ": account number already exist");
            }
            if (bankBase.getRountingNumber() == bank.getRountingNumber()) {
                throw new Exception(bank.getRountingNumber() + ": routing number already exist");
            }
        }
        bankRecords.add(bank);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public long getRountingNumber() {
        return routingNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setRoutingNumber(long routingNumber) {
        this.routingNumber = routingNumber;
    }


    // сделать так, чтобы у каждого банка была своя база данных
    // сколько в мбанке, сколько в демире и сколько в оптиме
    // потом их нужно сгруппировать мол, в мбанке столько, в оптиме столько, в демире столько
}
