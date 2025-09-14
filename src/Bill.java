public class Bill {
    private final int billId;
    private double amount;
    private boolean paid;
    private int patientId;

    public Bill(int billId, double amount, int patientId) {
        this.billId = billId;
        this.amount = amount;
        this.patientId = patientId;
        paid = false;
    }

    public boolean isPaid() {
        return paid;
    }

    public int getBillId() {
        return billId;
    }

    public double getAmount() {
        return amount;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bill Id=" + billId +
                ", amount=" + amount +
                ", paid=" + paid +
                ", patient Id=" + patientId +
                '}';
    }
}
