package PaymentProcessing;

public class BankTransfer extends PaymentMethod {

    String accountNumber, bankName;

    public BankTransfer(String accountNumber, String bankName) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

    @Override
    public void processPayment(double amount) throws InvalidPaymentDetailsException, InsuffiecientFundsException {
        if (!validatePaymentDetails()) throw new InvalidPaymentDetailsException("Invalid Payment Details");
        if (amount > 1000) throw new InsuffiecientFundsException("Insufficient Funds");
        status = "Bank Transfer Payment";

    }

    @Override
    public boolean validatePaymentDetails() {
        return accountNumber != null && accountNumber.matches("\\d{10,16}") && bankName != null;
    }
}
