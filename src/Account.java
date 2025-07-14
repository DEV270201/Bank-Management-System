public abstract class Account {
    private String accountNumber;
    private String accountType;
    private double accountBalance;

    Account(String accountNumber, String accountType, double accountBalance) {
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public void deposit(double amount) {
        this.accountBalance += amount;
        System.out.println("Money deposited successfully!");
        return;
    }

    public abstract void withdraw(double amount);

    public void checkAccountBalance(){
        System.out.println("The current balancer for this account: " + this.accountBalance);
        return;
    }

    public void getAccountType(){
        System.out.println("Current Account Type: " + this.accountType);
        return;
    }

    public double getAccountBalance(){
        return this.accountBalance;
    }

    public void updateAccountBalance(double amt){
        this.accountBalance = amt;
    }
}
