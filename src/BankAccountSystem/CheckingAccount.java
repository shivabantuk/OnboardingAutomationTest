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
            return false;
        return super.withdraw(amount);
    }
}
