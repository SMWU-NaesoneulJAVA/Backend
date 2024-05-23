package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.ExpenditureDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenditureDetailsServiceImpl implements ExpenditureDetailsService {
    private final ExpenditureDetailsRepository expenditureDetailsRepository;

    @Autowired
    public ExpenditureDetailsServiceImpl(ExpenditureDetailsRepository expenditureDetailsRepository) {
        this.expenditureDetailsRepository = expenditureDetailsRepository;
    }

    @Override
    public List<ExpenditureDetails> getAllExpenditureDetailsByAccountId(String accountId) {
        return expenditureDetailsRepository.findByAccountId(accountId);
    }

    @Override
    public ExpenditureDetails createExpenditure(ExpenditureDetails expenditureDetails) {
        return expenditureDetailsRepository.save(expenditureDetails);
    }

    @Override
    public ExpenditureDetails updateExpenditure(Long id, ExpenditureDetails expenditureDetails) {
        if (expenditureDetailsRepository.existsById(id)) {
            expenditureDetails.setId(id);
            return expenditureDetailsRepository.save(expenditureDetails);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteExpenditure(Long id) {
        if (expenditureDetailsRepository.existsById(id)) {
            expenditureDetailsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
