//Don't forget about imports
public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount bank1 = new BankAccount(1500.00, 5000.00);
        BankAccount bank2 = new BankAccount(255.32, 100.09);
        //test code here
        System.out.println(BankAccount.numberOfAccounts);
        System.out.println(BankAccount.totalStored);
        
        System.out.println(BankAccount.totalStored);
        bank2.checkBalances();
        bank2.makeWithdrawal("checking", 25.25);
        bank2.checkBalances();
        bank2.makeDeposit("savings", 1000.25);
        System.out.println(BankAccount.totalStored);
        bank1.getAccountNumber();
    }
}