package SMWU.NaesoneulJAVA.NidonNaedon.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "환율 정보 DTO")
public class ExchangeRateDTO {

    @Schema(description = "환율 ID", example = "1")
    private Long id;

    @Schema(description = "화폐 단위", example = "USD")
    private String currency;

    @Schema(description = "날짜", example = "2023-01-01")
    private String date;

    @Schema(description = "환율", example = "1.0")
    private double rate;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
