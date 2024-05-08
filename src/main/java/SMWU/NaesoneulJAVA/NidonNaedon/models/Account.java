package SMWU.NaesoneulJAVA.NidonNaedon.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Account {
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountSchedule() {
        return accountSchedule;
    }

    public void setAccountSchedule(String accountSchedule) {
        this.accountSchedule = accountSchedule;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public Double getAccountExchangeRate() {
        return accountExchangeRate;
    }

    public void setAccountExchangeRate(Double accountExchangeRate) {
        this.accountExchangeRate = accountExchangeRate;
    }

    public List<String> getAccountParticipantList() {
        return accountParticipantList;
    }

    public void setAccountParticipantList(List<String> accountParticipantList) {
        this.accountParticipantList = accountParticipantList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String accountId;
    private String accountName;
    private String accountSchedule;
    private String accountCurrency;
    private Double accountExchangeRate;

    @ElementCollection
    private List<String> accountParticipantList;
}
