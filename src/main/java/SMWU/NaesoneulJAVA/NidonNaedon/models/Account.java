package SMWU.NaesoneulJAVA.NidonNaedon.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String accountId;

    private String accountName;
    private String accountSchedule;
    private String accountCurrency;
    private Double accountExchangeRate;

    @Column(columnDefinition = "TEXT")
    private String accountParticipantList; // JSON 문자열로 저장할 필드

    @PrePersist
    public void prePersist() {
        if (this.accountId == null || this.accountId.isEmpty()) {
            this.accountId = "ai" + UUID.randomUUID().toString();
        }
    }

    // JSON 변환을 위한 ObjectMapper
    @Transient
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // 참가자 목록을 JSON 문자열로 변환하여 저장하는 메서드
    public void setAccountParticipantList(List<String> participants) {
        try {
            this.accountParticipantList = objectMapper.writeValueAsString(participants);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    // JSON 문자열을 List로 변환하여 반환하는 메서드
    public List<String> getAccountParticipantList() {
        try {
            return objectMapper.readValue(accountParticipantList, new TypeReference<List<String>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

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
}
