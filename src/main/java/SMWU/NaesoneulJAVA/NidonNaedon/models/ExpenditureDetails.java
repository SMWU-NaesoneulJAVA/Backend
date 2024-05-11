package SMWU.NaesoneulJAVA.NidonNaedon.models;

import java.time.LocalDate;
import java.util.List;

public class ExpenditureDetails {
    private String expenditureId;
    private String expenditureName;
    private double expenditureAmount;
    private String expenditureCurrency;
    private double expenditureExchangeRate;
    private List<String> expenditureParticipant;
    private String expenditureDate;
    private String expenditurePhoto;

    public ExpenditureDetails(String expenditureId, String expenditureName, double expenditureAmount, String expenditureCurrency, double expenditureExchangeRate, List<String> expenditureParticipant, String expenditureDate, String expenditurePhoto) {
        this.expenditureId = expenditureId;
        this.expenditureName = expenditureName;
        this.expenditureAmount = expenditureAmount;
        this.expenditureCurrency = expenditureCurrency;
        this.expenditureExchangeRate = expenditureExchangeRate;
        this.expenditureParticipant = expenditureParticipant;
        this.expenditureDate = expenditureDate;
        this.expenditurePhoto = expenditurePhoto;
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

}
