package PaymentProcessing;

class Transaction {
    String type;
    double amount;
    String status;

    public Transaction(String type, double amount, String status) {
        this.type = type;
        this.amount = amount;
        this.status = status;
    }

    public String toString() {
        return String.format(type + " " + amount + " " + status);
    }

}
