package SMWU.NaesoneulJAVA.NidonNaedon.repositories;

import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;
import SMWU.NaesoneulJAVA.NidonNaedon.services.ExpenditureDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExpenditureDetailsRepositoryTest {

    @Mock
    private ExpenditureDetailsRepository expenditureDetailsRepository;

    @InjectMocks
    private ExpenditureDetailsService expenditureDetailsService;

    @Test
    public void testGetAllExpenditureDetails() {
        String accountId = "ai/testId";

        ExpenditureDetails expenditure1 = new ExpenditureDetails("expenditureId1", "Expenditure 1", 100.0, "USD", 1.0, List.of("Participant1", "Participant2"), "20240501", "photo1.jpg");

        ExpenditureDetails expenditure2 = new ExpenditureDetails("expenditureId2", "Expenditure 2", 200.0, "EUR", 1.2, List.of("Participant3", "Participant4"), "20240301", null);

        List<ExpenditureDetails> mockExpenditureList = List.of(expenditure1, expenditure2);

        // Mock repository 설정
        when(expenditureDetailsRepository.findByAccountId(accountId)).thenReturn(mockExpenditureList);

        // 서비스 호출
        List<ExpenditureDetails> result = expenditureDetailsService.getAllExpenditureDetailsByAccountId(accountId);

        // 결과 검증
        assertNotNull(result);
        assertEquals(2, result.size());

        ExpenditureDetails firstExpenditure = result.get(0);
        assertEquals("expenditureId1", firstExpenditure.getExpenditureId());
        assertEquals("Expenditure 1", firstExpenditure.getExpenditureName());
        assertEquals(100.0, firstExpenditure.getExpenditureAmount());
        assertEquals("USD", firstExpenditure.getExpenditureCurrency());
        assertEquals(1.0, firstExpenditure.getExpenditureExchangeRate());
        assertEquals(List.of("Participant1", "Participant2"), firstExpenditure.getExpenditureParticipant());
        assertEquals("20240501", firstExpenditure.getExpenditureDate());
        assertEquals("photo1.jpg", firstExpenditure.getExpenditurePhoto());

        ExpenditureDetails secondExpenditure = result.get(1);
        assertEquals("expenditureId2", secondExpenditure.getExpenditureId());
        assertEquals("Expenditure 2", secondExpenditure.getExpenditureName());
        assertEquals(200.0, secondExpenditure.getExpenditureAmount());
        assertEquals("EUR", secondExpenditure.getExpenditureCurrency());
        assertEquals(1.2, secondExpenditure.getExpenditureExchangeRate());
        assertEquals(List.of("Participant3", "Participant4"), secondExpenditure.getExpenditureParticipant());
        assertEquals("20240301", secondExpenditure.getExpenditureDate());
        assertNull(secondExpenditure.getExpenditurePhoto());
    }
}