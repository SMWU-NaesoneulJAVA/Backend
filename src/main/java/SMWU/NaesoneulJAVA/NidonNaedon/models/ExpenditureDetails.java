package SMWU.NaesoneulJAVA.NidonNaedon.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class ExpenditureDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Expenditure ID is required")
    private String expenditureId;

    @NotNull(message = "Expenditure name is required")
    private String expenditureName;

    private double expenditureAmount;

    @NotNull(message = "Expenditure currency is required")
    private String expenditureCurrency;

    private double expenditureExchangeRate;

    @ElementCollection
    @Size(min = 1, message = "At least one participant is required")
    private List<String> expenditureParticipant;

    @NotNull(message = "Expenditure date is required")
    private String expenditureDate;

    private String expenditurePhoto;
    private String accountId;

    @NotNull(message = "Expenditure category is required")
    private String expenditureCategory;

    // No-arg 생성자 추가
    public ExpenditureDetails() {
    }

    // 생성자 추가
    public ExpenditureDetails(String expenditureId, String expenditureName, double expenditureAmount,
                              String expenditureCurrency, double expenditureExchangeRate,
                              List<String> expenditureParticipant, String expenditureDate,
                              String expenditurePhoto, String accountId) {
        this.expenditureId = expenditureId;
        this.expenditureName = expenditureName;
        this.expenditureAmount = expenditureAmount;
        this.expenditureCurrency = expenditureCurrency;
        this.expenditureExchangeRate = expenditureExchangeRate;
        this.expenditureParticipant = expenditureParticipant;
        this.expenditureDate = expenditureDate;
        this.expenditurePhoto = expenditurePhoto;
        this.accountId = accountId;
        this.expenditureCategory = "defaultCategory"; // 기본 카테고리 설정
    }

    // Getter 및 Setter 메서드
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
