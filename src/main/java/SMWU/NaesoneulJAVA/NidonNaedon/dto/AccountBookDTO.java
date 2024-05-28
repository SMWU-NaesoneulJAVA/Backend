package SMWU.NaesoneulJAVA.NidonNaedon.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "가계부 장부 DTO")
public class AccountBookDTO {

    @Schema(description = "계정 장부 ID", example = "1")
    private Long id;

    @Schema(description = "가계부 ID", example = "ai12345678-1234-1234-1234-123456789012")
    private String accountId;

    @Schema(description = "지출 내역 목록")
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
