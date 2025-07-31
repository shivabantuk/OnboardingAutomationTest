package PaymentProcessing;

abstract class PaymentMethod {
    protected String status = "Initialized";

    public abstract void processPayment(double amount) throws InvalidPaymentDetailsException, InsuffiecientFundsException;

    public abstract boolean validatePaymentDetails();

    public String getPaymentStatus() {
        return status;
    }

}
