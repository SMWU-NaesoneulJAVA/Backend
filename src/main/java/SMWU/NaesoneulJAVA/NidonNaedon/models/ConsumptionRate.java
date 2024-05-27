package SMWU.NaesoneulJAVA.NidonNaedon.models;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "소비율 정보")
public class ConsumptionRate {
    @Schema(description = "계정 이메일", example = "example@example.com")
    private String account_email;

    @Schema(description = "소비 금액", example = "100.0")
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
