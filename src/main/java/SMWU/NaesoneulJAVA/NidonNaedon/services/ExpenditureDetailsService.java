package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.ExpenditureDetailsDTO;
import java.util.List;

public interface ExpenditureDetailsService {
    List<ExpenditureDetailsDTO> getAllExpenditureDetailsByAccountId(String accountId);
    ExpenditureDetailsDTO createExpenditure(ExpenditureDetailsDTO expenditureDetailsDTO);
    ExpenditureDetailsDTO updateExpenditure(Long id, ExpenditureDetailsDTO expenditureDetailsDTO);
    boolean deleteExpenditure(Long id);
    ExpenditureDetailsDTO getExpenditureById(Long id);
}
