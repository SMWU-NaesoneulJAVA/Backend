package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;

import java.util.List;

public interface ExpenditureDetailsService {
    List<ExpenditureDetails> getAllExpenditureDetailsByAccountId(String accountId);
    ExpenditureDetails createExpenditure(ExpenditureDetails expenditureDetails);
    ExpenditureDetails updateExpenditure(Long id, ExpenditureDetails expenditureDetails);
    boolean deleteExpenditure(Long id);
}
