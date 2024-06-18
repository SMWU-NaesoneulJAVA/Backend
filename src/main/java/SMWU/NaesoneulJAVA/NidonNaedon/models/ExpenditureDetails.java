package SMWU.NaesoneulJAVA.NidonNaedon.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class ExpenditureDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expenditureId;
    private String expenditureName;
    private double expenditureAmount;
    private String expenditureCurrency;
    private double expenditureExchangeRate;

    @ElementCollection
    private List<String> expenditureParticipant;
    private String expenditureDate;
    private String expenditurePhoto;
    private Long accountId;  // String에서 Long으로 변경
    private String expenditureCategory;
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
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
