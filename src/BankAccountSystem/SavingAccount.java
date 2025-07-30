package BankAccountSystem;

public class SavingAccount extends Account{
    private double interestRate;


    public SavingAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);

        this.interestRate = interestRate;
    }
    public void addInterest(){
        balance += balance * interestRate;

    }
}