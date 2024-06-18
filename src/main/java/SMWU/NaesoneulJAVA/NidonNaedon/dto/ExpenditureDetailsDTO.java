package SMWU.NaesoneulJAVA.NidonNaedon.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "지출 상세 정보 DTO")
public class ExpenditureDetailsDTO {

    @Schema(description = "지출 상세 ID", example = "1")
    private Long id;

    @Schema(description = "지출 ID", example = "exp12345678")
    private String expenditureId;

    @Schema(description = "지출 이름", example = "점심 식사")
    private String expenditureName;

    @Schema(description = "지출 금액", example = "15000")
    private double expenditureAmount;

    @Schema(description = "지출 화폐", example = "KRW")
    private String expenditureCurrency;

    @Schema(description = "환율", example = "1.0")
    private double expenditureExchangeRate;

    @Schema(description = "참여자 목록")
    private List<String> expenditureParticipant;

    @Schema(description = "지출 날짜", example = "2023-01-01")
    private String expenditureDate;

    @Schema(description = "지출 사진")
    private String expenditurePhoto;

    @Schema(description = "계정 ID", example = "1")
    private Long accountId;  // 타입을 Long으로 변경

    @Schema(description = "지출 카테고리", example = "음식")
    private String expenditureCategory;

    @Schema(description = "비율", example = "1.0")
    private double proportion;

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

    public Long getAccountId() {  // 반환 타입을 Long으로 변경
        return accountId;
    }

    public void setAccountId(Long accountId) {  // 파라미터 타입을 Long으로 변경
        this.accountId = accountId;
    }

    public String getExpenditureCategory() {
        return expenditureCategory;
    }

    public void setExpenditureCategory(String expenditureCategory) {
        this.expenditureCategory = expenditureCategory;
    }

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) {
        this.proportion = proportion;
    }
}
