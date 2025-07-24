package com.bank;
import com.bank.exception.AccountNotFoundException;

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
    void closeBankAccount(String accountNumber) throws AccountNotFoundException {
        Account account = getAccount(accountNumber);
        if(account == null){
            throw new AccountNotFoundException("No such account exists in your profile!", "ACC_NOT_FOUND", accountNumber);
        }

        //close the account only if its balance is greater than zero else throw an error
        if(!(account.getAccountBalance() >= 0.0)){
            System.out.println("Cannot close the account. Negative Balance!.");
            return;
        }

        accounts.remove(accountNumber);
        System.out.println("Your account has been closed successfully!");
    }

    //list accounts
    void listAccounts() {
        if(accounts.isEmpty()){
            System.out.println("No accounts yet....");
            return;
        }

        System.out.println("Listing your Accounts: ");
        int counter = 1;
        for(String key: accounts.keySet()) {
            System.out.println(counter + "." + key);
            counter++;
        }
    }

    Account getAccount(String accountNumber){
        return accounts.get(accountNumber);
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
