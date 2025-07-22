package com.bank;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    CheckingAccount(){
        super("Checking",0.0);
        this.overdraftLimit = 100.0;
    }

    public void withdraw(double amt) {
        double accntBalance = getAccountBalance();
        //not letting the accnt balance to fall below overdraft limit
        if(accntBalance - amt + overdraftLimit < 0){
            System.out.println("Sorry, cannot withdraw. Overdraft limit will exceed!");
            return;
        }

        if(amt > 5000.0){
            System.out.println("Cannot withdraw more than 5000.0");
            return;
        }

        accntBalance =- amt;
        this.updateAccountBalance(accntBalance);
        System.out.println("Money withdrawn successfully!");
        return;
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
