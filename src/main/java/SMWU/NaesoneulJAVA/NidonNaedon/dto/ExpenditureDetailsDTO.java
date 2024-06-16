package SMWU.NaesoneulJAVA.NidonNaedon.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "지출 내역 DTO")
public class ExpenditureDetailsDTO {

    @Schema(description = "지출 내역 ID", example = "1")
    private Long id;

    @Schema(description = "지출 ID", example = "exp1234")
    private String expenditureId;

    @Schema(description = "지출 이름", example = "점심 식사")
    private String expenditureName;

    @Schema(description = "지출 금액", example = "100.0")
    private double expenditureAmount;

    @Schema(description = "지출 화폐", example = "KRW")
    private String expenditureCurrency;

    @Schema(description = "지출 환율", example = "1.0")
    private double expenditureExchangeRate;

    @Schema(description = "지출 참여자 목록")
    private List<String> expenditureParticipant;

    @Schema(description = "지출 날짜", example = "2023-01-01")
    private String expenditureDate;

    @Schema(description = "지출 사진 경로", example = "/path/to/photo.jpg")
    private String expenditurePhoto;

    @Schema(description = "계정 ID", example = "ai/12345678-1234-1234-1234-123456789012")
    private String accountId;

    @Schema(description = "지출 카테고리", example = "식사")
    private String expenditureCategory;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(String expenditureId) {
        this.expenditureId = expenditureId;
    }

    public String getExpenditureName() {
        return expenditureName;
    }

    public void setExpenditureName(String expenditureName) {
        this.expenditureName = expenditureName;
    }

    public double getExpenditureAmount() {
        return expenditureAmount;
    }

    public void setExpenditureAmount(double expenditureAmount) {
        this.expenditureAmount = expenditureAmount;
    }

    public String getExpenditureCurrency() {
        return expenditureCurrency;
    }

    public void setExpenditureCurrency(String expenditureCurrency) {
        this.expenditureCurrency = expenditureCurrency;
    }

    public double getExpenditureExchangeRate() {
        return expenditureExchangeRate;
    }

    public void setExpenditureExchangeRate(double expenditureExchangeRate) {
        this.expenditureExchangeRate = expenditureExchangeRate;
    }

    public List<String> getExpenditureParticipant() {
        return expenditureParticipant;
    }

    public void setExpenditureParticipant(List<String> expenditureParticipant) {
        this.expenditureParticipant = expenditureParticipant;
    }

    public String getExpenditureDate() {
        return expenditureDate;
    }

    public void setExpenditureDate(String expenditureDate) {
        this.expenditureDate = expenditureDate;
    }

    public String getExpenditurePhoto() {
        return expenditurePhoto;
    }

    public void setExpenditurePhoto(String expenditurePhoto) {
        this.expenditurePhoto = expenditurePhoto;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getExpenditureCategory() {
        return expenditureCategory;
    }

    public void setExpenditureCategory(String expenditureCategory) {
        this.expenditureCategory = expenditureCategory;
    }
}
