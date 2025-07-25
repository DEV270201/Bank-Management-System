package com.bank;

import com.bank.exception.BankingException;
import com.bank.exception.ExceedWithdrawalException;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    CheckingAccount(){
        super("Checking",0.0);
        this.overdraftLimit = 100.0;
    }

    @Override
    public void withdraw(double amt) throws BankingException {
        double accntBalance = getAccountBalance();
        //not letting the accnt balance to fall below overdraft limit
        if(accntBalance - amt + overdraftLimit < 0){
            throw new BankingException("Sorry, cannot withdraw. Overdraft limit will exceed!", "BANK_EXC");
        }

        if(amt > this.withdrawalLimit){
            throw new ExceedWithdrawalException(String.format("Cannot withdraw more than %.2f",this.withdrawalLimit),"EXCEED_WIT_LIMIT",amt,this.withdrawalLimit);
        }

        accntBalance =- amt;
        this.updateAccountBalance(accntBalance);
        System.out.println("Money withdrawn successfully!");
    }

    public double getOverdraftLimit(){
        return this.overdraftLimit;
    }

    @Override
    void getAccountDetails(){
        System.out.println("Account ID : " + this.getAccountNumber());
        System.out.println("Account Type : " + this.getAccountType());
        System.out.println("Account Balance : " + this.getAccountBalance());
        System.out.println("Account OverDraft Limit : " + this.overdraftLimit);
    }
}
