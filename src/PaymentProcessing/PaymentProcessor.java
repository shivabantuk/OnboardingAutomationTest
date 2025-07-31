package PaymentProcessing;

import java.util.ArrayList;

class PaymentProcessor {

    ArrayList<Transaction> history = new ArrayList<Transaction>();

    public void process(PaymentMethod method, double amount) throws InsuffiecientFundsException, InvalidPaymentDetailsException {
        try {
            method.processPayment(amount);
            history.add(new Transaction(method.getClass().getSimpleName(), amount, "success"));
            System.out.println("Payment Successful " + method.getPaymentStatus());
        } catch (InsuffiecientFundsException e) {

            history.add(new Transaction(method.getClass().getSimpleName(), amount, "Failed"));
            System.out.println("Payment Failed " + e.getMessage());
        }

    }

    public ArrayList<Transaction> getHistory() {
        return history;
    }


}
