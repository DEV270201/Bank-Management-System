package com.bank;
import com.bank.exception.BankingException;
import com.bank.exception.ExceedDepositException;

import java.util.UUID;

//keep getters and setters as public

public abstract class Account {
    private String accountNumber;
    private String accountType;
    private double accountBalance;
    protected double depositLimit;
    protected double withdrawalLimit;

    public Account(String accountType, double accountBalance) {
        this.accountBalance = accountBalance;
        this.accountNumber = UUID.randomUUID().toString();
        this.accountType = accountType;
        this.depositLimit = 5000.0;
        this.withdrawalLimit = 5000.0;
    }

    public final void deposit(double amount) throws ExceedDepositException {
        //check at a time, a person can deposit no more than 5000 in a single transaction
        if(amount > this.depositLimit){
            throw new ExceedDepositException(String.format("Deposits exceeded %.2f limit!",this.depositLimit), "EXCEED_DEP_LIMIT", amount, this.depositLimit);
        }
        this.accountBalance += amount;
        System.out.println("Money deposited successfully!");
    }

    protected abstract void withdraw (double amount) throws BankingException;

    protected void checkAccountBalance(){
        System.out.println("The current balancer for this account: " + this.accountBalance);
        return;
    }

    protected String getAccountType(){
        return this.accountType;
    }

    protected String getAccountNumber() {
        return this.accountNumber;
    }

    protected double getAccountBalance(){
        return this.accountBalance;
    }

    protected void updateAccountBalance(double amt){
        this.accountBalance = amt;
    }

    abstract void getAccountDetails();
}
