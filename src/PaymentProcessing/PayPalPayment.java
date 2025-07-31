package PaymentProcessing;

public class PayPalPayment extends PaymentMethod {

    String email, password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void processPayment(double amount) throws InvalidPaymentDetailsException, InsuffiecientFundsException {
        if (!validatePaymentDetails()) throw new InvalidPaymentDetailsException("Invalid Payment Details");
        if (amount > 1000) throw new InsuffiecientFundsException("Insufficient Paypal Funds");
        status = "Paypal payment Payment";

    }

    @Override
    public boolean validatePaymentDetails() {
        return email != null && email.contains("@") && password != null && password.length() >= 5;
    }
}
