package com.bank;

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

    public void withdraw(double amount) {
        double accntBalance = getAccountBalance();
        if(accntBalance <= threshold){
            System.out.println("Sorry cannot withdraw. Threshold balance reached!");
            return;
        }
        if(accntBalance - amount <= 0){
            System.out.println("Insufficient money to withdraw!");
            return;
        }

        if(amount > 5000.0){
            System.out.println("Cannot withdraw more than 5000.0");
            return;
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
