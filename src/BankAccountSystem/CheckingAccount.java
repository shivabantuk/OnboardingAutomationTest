package BankAccountSystem;

public class CheckingAccount extends Account {
    private double transactionLimit;

    public CheckingAccount(String accountNumber, double balance, double transactionLimit) {
        super(accountNumber, balance);
        this.transactionLimit = transactionLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount >transactionLimit )
        {
            System.out.println("Amount is greater than transaction limit");
            return false;

        }
        else
        {
            System.out.println("Withdrawal Successful");
        }
        return super.withdraw(amount);
    }
}
