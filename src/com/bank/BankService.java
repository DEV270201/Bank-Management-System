package com.bank;

import com.bank.exception.*;

import java.util.HashMap;
import java.util.Scanner;

public class BankService {
    public HashMap<String,Customer> people;
    BankService(){
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
                    try{
                    accountNumber = getCustomerAccountNumber(sc);
                    cust.closeBankAccount(accountNumber);
                    }catch (AccountNotFoundException err){
                        System.out.println(err.getErrorMessage());
                        System.out.println("ACC No: " + err.getAccountNumber());
                    }
                    catch(BankingException err){
                        System.out.println(err.getErrorMessage());
                    }
                    break;

                case 5:
                    //deposit money
                    try{
                    accountNumber = getCustomerAccountNumber(sc);
                    account = cust.getAccount(accountNumber);

                    if(account == null){
                        throw new AccountNotFoundException("No such account exists in your profile!","ACC_NOT_FOUND",accountNumber);
                    }

                    System.out.println("Enter deposit amount: ");
                    double depositMoney = sc.nextDouble();
                    account.deposit(depositMoney);
                    }
                    catch (ExceedDepositException err){
                        System.out.println(err.getErrorMessage());
                        System.out.println("Deposit Limit: " + err.getDepositLimit() + ". Money deposit: " + err.getTotalAmount());
                    }
                    catch (BankingException err){
                        System.out.println(err.getErrorMessage());
                    }
                    break;

                case 6:
                    //withdraw money
                    try{
                    accountNumber = getCustomerAccountNumber(sc);
                    account = cust.getAccount(accountNumber);

                    if(account == null){
                        throw new AccountNotFoundException("No such account exists in your profile!", "ACC_NOT_FOUND", accountNumber);
                    }

                    System.out.println("Current Account Balance: " + account.getAccountBalance());
                    System.out.println("Enter withdraw amount: ");
                    double wihtdrawMoney = sc.nextDouble();
                    account.withdraw(wihtdrawMoney);
                    }catch (InsufficientBalance err){
                        System.out.println(err.getErrorMessage());
                        System.out.println("Available Balance: " + err.getAvailableBalance() + ". Money requested: " + err.getMoneyRequested());
                    }catch (AccountNotFoundException err){
                        System.out.println(err.getErrorMessage());
                        System.out.println("ACC No: " + err.getAccountNumber());
                    }catch(ExceedWithdrawalException err){
                        System.out.println(err.getErrorMessage());
                        System.out.println("Withdrawal limit: " + err.getWithdrawLimit() + ". Money withdraw: " + err.getTotalAmount());
                    }catch(BankingException err){
                        System.out.println(err.getErrorMessage());
                    }
                    break;

                case 7:
                    //check account balance
                    try{
                    accountNumber = getCustomerAccountNumber(sc);
                    account = cust.getAccount(accountNumber);

                    if(account == null){
                        throw new AccountNotFoundException("Account not found!","ACC_NOT_FOUND",accountNumber);
                    }

                    double accountBalance = account.getAccountBalance();
                    System.out.println("Your current account balance is " + accountBalance);

                    }catch (AccountNotFoundException err){
                        System.out.println(err.getErrorMessage());
                        System.out.println("ACC No: " + err.getAccountNumber());
                    }
                    break;

                case 8:
                    //check account details
                    try{
                   accountNumber = getCustomerAccountNumber(sc);
                   account = cust.getAccount(accountNumber);

                   if(account == null){
                       throw new AccountNotFoundException("Account not found!","ACC_NOT_FOUND",accountNumber);
                   }
                   account.getAccountDetails();

                   }catch (AccountNotFoundException err){
                        System.out.println(err.getErrorMessage());
                        System.out.println("ACC No: " + err.getAccountNumber());
                   }
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
