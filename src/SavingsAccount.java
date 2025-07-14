public class SavingsAccount extends Account{
    private static double interestRate;
    private double threshold;

    SavingsAccount() {
        super("", "Savings", 0.0);
        this.threshold = threshold;
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

        accntBalance -= amount;
        updateAccountBalance(accntBalance);
        System.out.println("Money withdrawn successfully!");
        return;
    }

    //write logic for updating account balance after every some time

}
