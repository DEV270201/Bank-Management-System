package com.bank;

import java.util.HashMap;
import java.util.Scanner;

public class Bank {
    public HashMap<String,Customer> people;
    Bank(){
        people = new HashMap<String,Customer>();
    }

    //create person
    public void createPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name : ");
        String name = sc.nextLine();
        System.out.println("Enter your Email : ");
        String email = sc.nextLine();
        System.out.println("Enter your Location : ");
        String location = sc.nextLine();
        Customer cust = new Customer(name,email.toLowerCase(),location);
        people.put(email,cust);
        System.out.println("Profile created successfully!");
    }

    private static Account getCustomerAccountNumber(Scanner sc, Customer cust){
        System.out.println("Enter your account number: ");
        String accountNumber = sc.nextLine();
        Account account = cust.getAccount(accountNumber);
        if(account == null)
            System.out.println("Invalid account number....");
        return account;
    }

    //login into the profile
    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Email to login: ");
        String email = sc.nextLine();
        if(!people.containsKey(email.toLowerCase())){
            System.out.println("Sorry, no such profile exists!");
            return;
        }

        Customer cust = people.get(email.toLowerCase());
        while(true){
            System.out.println("Banking Tasks : ");
            System.out.println("1. Open Checkings Account");
            System.out.println("2. Open Savings Account ");
            System.out.println("3. List Accounts");
            System.out.println("4. Close Account ");
            System.out.println("5. Deposit Money");
            System.out.println("6. Withdraw Money");
            System.out.println("7. Check Account Balance");
            System.out.println("8. Check Account Details");
            System.out.println("9. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    //opening a checking account
                    cust.openBankAccount("Checking");
                    break;

                case 2:
                    //open a savings account
                    cust.openBankAccount("Savings");
                    break;

                case 3:
                    //listing all user accounts
                    cust.listAccounts();
                    break;

                case 4:
                    //close an account

                    
                case 5:
                    //deposit money


                case 6:
                    //withdraw money

                case 7:
                    //check account balance
                    Account account = getCustomerAccountNumber(sc,cust);
                    if(account != null){
                        double accountBalance = account.getAccountBalance();
                        System.out.println("Your current account balance is " + accountBalance);
                    }
                    break;

                case 8:
                    //check account details
                   account = getCustomerAccountNumber(sc,cust);
                   if(account != null)
                     account.getAccountDetails();
                   break;

                case 9:
                    System.out.println("Ohh! I hope we provided all the desired services....");
                    break;

                default:
                    System.out.println("Invalid input :(");
            }

            if(choice == 9)
                break;
        }

        return;
    }
}
