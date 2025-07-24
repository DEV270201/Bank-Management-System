package com.bank.exception;

public class InsufficientBalance extends BankingException{
    private double availableBalance;
    private double moneyRequested;

    public InsufficientBalance(String message, String errorCode, double availableBalance, double moneyRequested) {
        super(message,errorCode);
        this.availableBalance = availableBalance;
        this.moneyRequested = moneyRequested;
    }

    public double getAvailableBalance(){
        return this.availableBalance;
    }

    public double getMoneyRequested(){
        return this.moneyRequested;
    }

    public double getShortMoney(){
        return this.moneyRequested - this.availableBalance;
    }
}
