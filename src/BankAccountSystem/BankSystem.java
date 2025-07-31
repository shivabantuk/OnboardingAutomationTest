package BankAccountSystem;

public class BankSystem {
    public static void main(String[] args) {

        SavingAccount sa = new SavingAccount("123",1000, 5);
        sa.addInterest();
        CheckingAccount c = new CheckingAccount("123",1000, 2000);
        c.withdraw(1000);

    }
}
