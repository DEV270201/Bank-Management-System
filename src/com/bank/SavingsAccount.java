package com.bank;

import com.bank.exception.BankingException;
import com.bank.exception.ExceedWithdrawalException;
import com.bank.exception.InsufficientBalance;

public class SavingsAccount extends Account{
    private static final double interestRate;
    private double threshold;

    SavingsAccount() {
        super("Savings", 0.0);
        this.threshold = 100.0;
    }

    static {
        interestRate = 2.5;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public double getThreshold() {
        return this.threshold;
    }

    @Override
    public void withdraw(double amount) throws BankingException {
        double accntBalance = getAccountBalance();
        if(accntBalance <= threshold){
            throw new BankingException("Sorry cannot withdraw. Threshold balance reached!", "BANK_EXC");
        }

        if(accntBalance - amount <= 0){
            throw new InsufficientBalance("Insufficient money to withdraw!", "INSUFF_ACC_BAL", accntBalance, amount);
        }

        if(amount > this.withdrawalLimit){
            throw new ExceedWithdrawalException(String.format("Cannot withdraw more than %.2f",this.withdrawalLimit),"EXCEED_WIT_LIMIT",amount,this.withdrawalLimit);
        }

        accntBalance -= amount;
        this.updateAccountBalance(accntBalance);
        System.out.println("Money withdrawn successfully!");
    }

    @Override
    void getAccountDetails(){
        System.out.println("Account ID : " + this.getAccountNumber());
        System.out.println("Account Type : " + this.getAccountType());
        System.out.println("Account Balance : " + this.getAccountBalance());
        System.out.println("Account Threshold : " + this.threshold);
        System.out.println("Account Interest Rate : " + interestRate);
    }

    //write logic for updating account balance after every some time

}
