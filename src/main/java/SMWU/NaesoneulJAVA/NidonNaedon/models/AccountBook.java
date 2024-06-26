package SMWU.NaesoneulJAVA.NidonNaedon.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class AccountBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountId;

    @ElementCollection
    private List<String> expenditureList;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<String> getExpenditureList() {
        return expenditureList;
    }

    public void setExpenditureList(List<String> expenditureList) {
        this.expenditureList = expenditureList;
    }
}
