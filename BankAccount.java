import java.util.Random;

public class BankAccount {
    //start by defining the member variables. They should almost always be private.
    //Remember: member variables are accessed via getter and setter methods.
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;
    //static attributes
    public static int numberOfAccounts = 0;
    public static double totalStored = 0.0;
    //constructor
    public BankAccount(double checking, double savings) {
        checkingBalance = checking;
        savingsBalance = savings;
        accountNumber = generateAccountNumber();
        numberOfAccounts++;
        totalStored = totalStored + checkingBalance + savingsBalance;
    }
    //getter
    public double getCheckingBalance() {
        return checkingBalance;
    }
    //setter
    private void setCheckingBalance(double amt) {
        checkingBalance = checkingBalance + amt;
    }
    public double getSavingsBalance() {
        return savingsBalance;
    }
    private void setSavingsBalance(double amt) {
        savingsBalance = savingsBalance + amt;
    }

    public void getAccountNumber() {
        System.out.println(accountNumber);
    }

    private String generateAccountNumber() {
        Random randomInt = new Random();
        String accountNumber = "";
        for (int i=0; i<10; i++) {
            Integer rand = randomInt.nextInt(0, 9);
            String randChar = rand.toString();
            accountNumber = accountNumber + randChar;
        }
        return accountNumber;
    }

    //methods
    //Deposit - choose savings or checking; add to total stored
    public void makeDeposit(String acctType, double amt) {
        totalStored += amt;
        String acct = acctType.toLowerCase();
        if (acct.equals("checking")) {
            setCheckingBalance(amt);
        } else if (acct.equals("savings")) {
            setSavingsBalance(amt);
        } else System.out.println("Not a valid account type.");
    }
    //Withdraw - choose savings or checking; do not allow to go negative
    public void makeWithdrawal(String acctType, double amt) {
        String acct = acctType.toLowerCase();
        double amtNeg = (0 - amt);
        if (acct.equals("checking")) {
            if (checkingBalance - amt >= 0) {
            setCheckingBalance(amtNeg);
            } else System.out.println("Insufficient funds.");
        } else if (acct.equals("savings")) {
            if (savingsBalance - amt >= 0) {
                setSavingsBalance(amtNeg);
            } else System.out.println("Insufficient funds.");
        } else System.out.println("Invalid account type.");
    } 
    //Check balances
    public void checkBalances() {
        double check = getCheckingBalance();
        double save = getSavingsBalance();
        System.out.println("Checking balance: " + check + " Savings balance: " + save);
    }
    //Make sure users can not set attributes from the class - I believed this is achieved by having these set to private?
}