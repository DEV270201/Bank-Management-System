package com.bank.exception;

public class AccountNotFoundException extends BankingException{
    private String accountNumber;

    public AccountNotFoundException(String message, String errorCode, String accountNumber){
        super(message, errorCode);
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }
}
