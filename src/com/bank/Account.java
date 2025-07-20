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
        this.accountBalance += amount;
        System.out.println("Money deposited successfully!");
        return;
    }

    protected abstract void withdraw(double amount);

    public void checkAccountBalance(){
        System.out.println("The current balancer for this account: " + this.accountBalance);
        return;
    }

    public void getAccountType(){
        System.out.println("Current Account Type: " + this.accountType);
        return;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getAccountBalance(){
        return this.accountBalance;
    }

    public void updateAccountBalance(double amt){
        this.accountBalance = amt;
    }

    abstract void getAccountDetails();
}
