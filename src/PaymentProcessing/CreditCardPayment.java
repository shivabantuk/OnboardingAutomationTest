package PaymentProcessing;

public class CreditCardPayment extends PaymentMethod {
    String cardNumber, expiryDate, cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void processPayment(double amount) throws InvalidPaymentDetailsException, InsuffiecientFundsException {
        if (!validatePaymentDetails()) throw new InvalidPaymentDetailsException("Invalid Payment Details");
        if (amount > 1000) throw new InsuffiecientFundsException("Insufficient Funds");
        status = "Credit Card Payment";


    }

    @Override
    public boolean validatePaymentDetails() {
        return cardNumber != null && cardNumber.matches("//d{10,16}");
        //&& expiryDate != null && expiryDate.matches("//d{2}/\\d{2}") && cvv != null &&  cvv.matches("//{3}");

    }
}
