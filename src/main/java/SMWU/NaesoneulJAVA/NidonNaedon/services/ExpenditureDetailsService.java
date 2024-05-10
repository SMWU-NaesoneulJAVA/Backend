package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.ExpenditureDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenditureDetailsService {
    private final ExpenditureDetailsRepository expenditureDetailsRepository;

    @Autowired
    public ExpenditureDetailsService(ExpenditureDetailsRepository expenditureDetailsRepository) {
        this.expenditureDetailsRepository = expenditureDetailsRepository;
    }

    public List<ExpenditureDetails> getAllExpenditureDetailsByAccountId(String accountId) {
        return expenditureDetailsRepository.findByAccountId(accountId);
    }
}
