package SMWU.NaesoneulJAVA.NidonNaedon.models;

public class ConsumptionRate {
    private String account_email;
    private double amount;

    public ConsumptionRate(String account_email, double amount) {
        this.account_email = account_email;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccount_email() {
        return account_email;
    }

    public void setAccount_email(String account_email) {
        this.account_email = account_email;
    }

}
