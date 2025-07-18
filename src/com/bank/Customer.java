package com.bank;
import java.util.UUID;
import java.util.HashMap;

public class Customer {
    private String name;
    private String customerID;
    private String email;
    private String location;
    private HashMap<String,Account> accounts;

    Customer(String name, String email, String location){
        this.name = name;
        this.email = email;
        this.location = location;
        this.customerID = UUID.randomUUID().toString();
        this.accounts = new HashMap<String,Account>();
    }

    //open a bank account
    void openBankAccount(String accntType) {
        Account openingAccount;
        if(accntType.equals("Savings"))
           openingAccount = new SavingsAccount();
        else
            openingAccount = new CheckingAccount();

        accounts.put(openingAccount.getAccountNumber(),openingAccount);
        System.out.println("Your new " + accntType + " has been created successfully!");
    }

    //close a bank account
    void closeBankAccount(String accntNumber) {
        if(!accounts.containsKey(accntNumber)){
            System.out.println("No such Bank Account found on your profile.");
            return;
        }

        Account closingAccount = accounts.get(accntNumber);
        //close the account only if its balance is greater than zero else throw an error
        if(!(closingAccount.getAccountBalance() >= 0.0)){
            System.out.println("Cannot close the account. Negative Balance!.");
            return;
        }

        accounts.remove(accntNumber);
        System.out.println("Your account has been closed successfully!");
    }

    //fetching customer details
    void printCustomerDetails() {
        System.out.println("Customer Details : ");
        System.out.println("Customer iD -> " + this.customerID);
        System.out.println("Name -> " + this.name);
        System.out.println("Email -> " + this.email);
        System.out.println("Location -> " + this.location);
    }
}
