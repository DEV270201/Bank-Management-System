package com.bank;
import java.util.UUID;

//keep getters and setters as public

public abstract class Account {
    private String accountNumber;
    private String accountType;
    private double accountBalance;

    public Account(String accountType, double accountBalance) {
        this.accountBalance = accountBalance;
        this.accountNumber = UUID.randomUUID().toString();
        this.accountType = accountType;
    }

    public final void deposit(double amount) {
        //check at a time, a person can deposit no more than 5000 in a single transaction
        if(amount > 5000.0){
            System.out.println("Cannot deposit more than 5000.0");
            return;
        }
        this.accountBalance += amount;
        System.out.println("Money deposited successfully!");
    }

    protected abstract void withdraw(double amount);

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
