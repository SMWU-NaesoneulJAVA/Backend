package SMWU.NaesoneulJAVA.NidonNaedon.config;

import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.ExchangeRateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BankAPITest {

    @Mock
    private ExchangeRateRepository exchangeRateRepository;

    @InjectMocks
    private BankAPI bankAPI;

    @Test
    public void testSetExchangeRateUSD() {
        ExpenditureDetails expenditureUSD = new ExpenditureDetails(
                "1",
                "Test Expenditure USD",
                100.0,
                "USD",
                0.0,
                Arrays.asList("Participant 1", "Participant 2"),
                "20230512",
                "photo.jpg",
                "account1"
        );

        when(exchangeRateRepository.findByCurrencyAndDate(anyString(), anyString())).thenReturn(Optional.empty());

        bankAPI.setExchangeRate(expenditureUSD);

        System.out.println("Expenditure Exchange Rate (USD): " + expenditureUSD.getExpenditureExchangeRate());
    }

    @Test
    public void testSetExchangeRateEUR() {
        ExpenditureDetails expenditureEUR = new ExpenditureDetails(
                "2",
                "Test Expenditure EUR",
                200.0,
                "EUR",
                0.0,
                Arrays.asList("Participant 3", "Participant 4"),
                "20250501",
                "photo.jpg",
                "account2"
        );

        when(exchangeRateRepository.findByCurrencyAndDate(anyString(), anyString())).thenReturn(Optional.empty());

        bankAPI.setExchangeRate(expenditureEUR);

        System.out.println("Expenditure Exchange Rate (EUR): " + expenditureEUR.getExpenditureExchangeRate());
    }
}
