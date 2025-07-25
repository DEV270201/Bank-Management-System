package com.bank.exception;

public class BankingException extends Exception{
    private String errorCode;
    private String message;

    public BankingException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode(){
        return this.errorCode;
    }

    public String getErrorMessage(){
        return this.message;
    }
}
