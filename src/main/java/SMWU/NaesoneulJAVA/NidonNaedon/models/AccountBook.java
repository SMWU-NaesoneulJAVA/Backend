package SMWU.NaesoneulJAVA.NidonNaedon.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
@Schema(description = "가계부 장부")
public class AccountBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "계정 장부 ID", example = "1")
    private Long id;

    @Schema(description = "가계부 ID", example = "ai12345678-1234-1234-1234-123456789012")
    private String accountId;

    @ElementCollection
    @Schema(description = "지출 내역 목록")
    private List<String> expenditureList;

    public AccountBook() {}

    public AccountBook(String accountId, List<String> expenditureList) {
        this.accountId = accountId;
        this.expenditureList = expenditureList;
    }

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
