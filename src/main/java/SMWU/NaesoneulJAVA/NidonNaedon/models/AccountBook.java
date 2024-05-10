package SMWU.NaesoneulJAVA.NidonNaedon.models;

import java.util.List;

public class AccountBook {
    private String accountId;
    private List<String> expenditureList;

    public AccountBook(String accountId, List<String> expenditureList) {
        this.accountId = accountId;
        this.expenditureList = expenditureList;
    }

    public String getAccountId() {
        return accountId;
    }

    public List<String> getExpenditureList() {
        return expenditureList;
    }
}
