package com.bank.exception;

public class ExceedDepositException extends BankingException{
    private double totalAmount;
    private double depositLimit;
    public ExceedDepositException(String message, String errorCode, double amt, double depositLimit){
        super(message,errorCode);
        this.totalAmount = amt;
        this.depositLimit = depositLimit;
    }

    public double getTotalAmount(){
        return this.totalAmount;
    }

    public double getDepositLimit(){
        return this.depositLimit;
    }
}
