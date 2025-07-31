package PaymentProcessing;

public class InsuffiecientFundsException extends Exception {
    public InsuffiecientFundsException(String message) {
        super(message);
    }

}
