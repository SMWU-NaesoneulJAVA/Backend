package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.ExpenditureDetailsDTO;
import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.ExpenditureDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenditureDetailsServiceImpl implements ExpenditureDetailsService {

    private final ExpenditureDetailsRepository expenditureDetailsRepository;

    @Autowired
    public ExpenditureDetailsServiceImpl(ExpenditureDetailsRepository expenditureDetailsRepository) {
        this.expenditureDetailsRepository = expenditureDetailsRepository;
    }

    @Override
    public List<ExpenditureDetailsDTO> getAllExpenditureDetailsByAccountId(String accountId) {
        List<ExpenditureDetails> expenditures = expenditureDetailsRepository.findByAccountId(accountId);
        return expenditures.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ExpenditureDetailsDTO createExpenditure(ExpenditureDetailsDTO expenditureDetailsDTO) {
        ExpenditureDetails expenditureDetails = convertToEntity(expenditureDetailsDTO);
        ExpenditureDetails savedExpenditureDetails = expenditureDetailsRepository.save(expenditureDetails);
        return convertToDTO(savedExpenditureDetails);
    }

    @Override
    public ExpenditureDetailsDTO updateExpenditure(Long id, ExpenditureDetailsDTO expenditureDetailsDTO) {
        if (expenditureDetailsRepository.existsById(id)) {
            ExpenditureDetails expenditureDetails = convertToEntity(expenditureDetailsDTO);
            expenditureDetails.setId(id);
            ExpenditureDetails updatedExpenditureDetails = expenditureDetailsRepository.save(expenditureDetails);
            return convertToDTO(updatedExpenditureDetails);
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

    @Override
    public ExpenditureDetailsDTO getExpenditureById(Long id) {
        return expenditureDetailsRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    private ExpenditureDetailsDTO convertToDTO(ExpenditureDetails expenditureDetails) {
        ExpenditureDetailsDTO dto = new ExpenditureDetailsDTO();
        dto.setId(expenditureDetails.getId());
        dto.setExpenditureId(expenditureDetails.getExpenditureId());
        dto.setExpenditureName(expenditureDetails.getExpenditureName());
        dto.setExpenditureAmount(expenditureDetails.getExpenditureAmount());
        dto.setExpenditureCurrency(expenditureDetails.getExpenditureCurrency());
        dto.setExpenditureExchangeRate(expenditureDetails.getExpenditureExchangeRate());
        dto.setExpenditureParticipant(expenditureDetails.getExpenditureParticipant());
        dto.setExpenditureDate(expenditureDetails.getExpenditureDate());
        dto.setExpenditurePhoto(expenditureDetails.getExpenditurePhoto());
        dto.setAccountId(expenditureDetails.getAccountId());
        dto.setExpenditureCategory(expenditureDetails.getExpenditureCategory());
        return dto;
    }

    private ExpenditureDetails convertToEntity(ExpenditureDetailsDTO dto) {
        ExpenditureDetails expenditureDetails = new ExpenditureDetails();
        expenditureDetails.setId(dto.getId());
        expenditureDetails.setExpenditureId(dto.getExpenditureId());
        expenditureDetails.setExpenditureName(dto.getExpenditureName());
        expenditureDetails.setExpenditureAmount(dto.getExpenditureAmount());
        expenditureDetails.setExpenditureCurrency(dto.getExpenditureCurrency());
        expenditureDetails.setExpenditureExchangeRate(dto.getExpenditureExchangeRate());
        expenditureDetails.setExpenditureParticipant(dto.getExpenditureParticipant());
        expenditureDetails.setExpenditureDate(dto.getExpenditureDate());
        expenditureDetails.setExpenditurePhoto(dto.getExpenditurePhoto());
        expenditureDetails.setAccountId(dto.getAccountId());
        expenditureDetails.setExpenditureCategory(dto.getExpenditureCategory());
        return expenditureDetails;
    }
}
