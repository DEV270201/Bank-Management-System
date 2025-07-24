package com.bank.exception;

public class ExceedWithdrawalException extends BankingException{
    private double totalAmount;
    private double withdrawLimit;

    public ExceedWithdrawalException(String message, String errorCode, double amt, double withdrawLimit){
        super(message,errorCode);
        this.totalAmount = amt;
        this.withdrawLimit = withdrawLimit;
    }

    public double getTotalAmount(){
        return this.totalAmount;
    }

    public double getWithdrawLimit(){
        return this.withdrawLimit;
    }
}
