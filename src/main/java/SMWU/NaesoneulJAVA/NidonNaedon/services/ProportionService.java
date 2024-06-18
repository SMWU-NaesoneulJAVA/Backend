package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.ExpenditureDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProportionService {

    @Autowired
    private ExpenditureDetailsRepository expenditureDetailsRepository;

    public Map<String, Double> calculateProportion(Long accountId) {  // String에서 Long으로 변경
        List<ExpenditureDetails> expenditures = expenditureDetailsRepository.findByAccountId(accountId);
        Map<String, Double> totalAmounts = new HashMap<>();
        Map<String, Double> proportions = new HashMap<>();

        double totalAmount = 0.0;
        for (ExpenditureDetails expenditure : expenditures) {
            totalAmount += expenditure.getExpenditureAmount();
            for (String participant : expenditure.getExpenditureParticipant()) {
                totalAmounts.put(participant, totalAmounts.getOrDefault(participant, 0.0) + expenditure.getExpenditureAmount());
            }
        }

        for (Map.Entry<String, Double> entry : totalAmounts.entrySet()) {
            proportions.put(entry.getKey(), entry.getValue() / totalAmount);
        }

        return proportions;
    }
}
