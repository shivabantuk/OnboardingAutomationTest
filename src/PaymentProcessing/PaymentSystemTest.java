package PaymentProcessing;

public class PaymentSystemTest {
    public static void main(String[] args) throws InsuffiecientFundsException, InvalidPaymentDetailsException {
        PaymentProcessor processor = new PaymentProcessor();
        CreditCardPayment ccPayment = new CreditCardPayment("4111111111111111", "12/25", "123");
        CreditCardPayment ccPayementInvalid = new CreditCardPayment("1234567890123456", "01/20", "abc");
        PayPalPayment ppPayment = new PayPalPayment("user@example.com", "securePassword123");
        PayPalPayment ppPaymentInvalid = new PayPalPayment("invalidEmailFormat", "pass");
        BankTransfer bank = new BankTransfer("1234567890", "Bank of Java");
        BankTransfer bankInvalid = new BankTransfer("abc1234567", "");

        processor.process(bank, 500);
        processor.process(ppPayment, 500);
        processor.process(ppPaymentInvalid, 500);
        processor.process(bankInvalid, 500);


        for (Transaction t : processor.history) {
            System.out.println(t);
        }



    }
}
