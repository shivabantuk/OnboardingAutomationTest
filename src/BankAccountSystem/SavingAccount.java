package BankAccountSystem;

public class SavingAccount extends Account{
    private double interestRate;


    public SavingAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);

        this.interestRate = interestRate;
    }
    public void addInterest(){
        double interest = balance * interestRate/100;
        balance += interest;
        System.out.println("Interest Rate is " + interestRate);
        System.out.println("Interest is " + interest);

    }
}