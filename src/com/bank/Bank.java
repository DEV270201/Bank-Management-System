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

    private static String getCustomerAccountNumber(Scanner sc){
        System.out.println("Enter your account number: ");
        return sc.nextLine();
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
            String accountNumber;
            Account account;

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
                    accountNumber = getCustomerAccountNumber(sc);
                    cust.closeBankAccount(accountNumber);
                    break;

                case 5:
                    //deposit money
                    accountNumber = getCustomerAccountNumber(sc);
                    account = cust.getAccount(accountNumber);

                    if(account == null){
                        System.out.println("No such account exists in your profile!");
                        return;
                    }

                    System.out.println("Enter deposit amount: ");
                    double depositMoney = sc.nextDouble();
                    account.deposit(depositMoney);
                    break;

                case 6:
                    //withdraw money
                    accountNumber = getCustomerAccountNumber(sc);
                    account = cust.getAccount(accountNumber);

                    if(account == null){
                        System.out.println("No such account exists in your profile!");
                        return;
                    }

                    System.out.println("Current Account Balance: " + account.getAccountBalance());
                    System.out.println("Enter withdraw amount: ");
                    double wihtdrawMoney = sc.nextDouble();
                    account.withdraw(wihtdrawMoney);
                    break;

                case 7:
                    //check account balance
                    accountNumber = getCustomerAccountNumber(sc);
                    account = cust.getAccount(accountNumber);
                    if(account != null){
                        double accountBalance = account.getAccountBalance();
                        System.out.println("Your current account balance is " + accountBalance);
                    }
                    break;

                case 8:
                    //check account details
                   accountNumber = getCustomerAccountNumber(sc);
                   account = cust.getAccount(accountNumber);
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
    }
}
