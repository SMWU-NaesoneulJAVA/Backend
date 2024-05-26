package SMWU.NaesoneulJAVA.NidonNaedon.config;

import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;
import java.util.Arrays;

public class BankAPITest {
    public static void main(String[] args) {
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

        BankAPI bankAPI = new BankAPI();
        bankAPI.setExchangeRate(expenditureUSD);

        System.out.println("Expenditure Exchange Rate (USD): " + expenditureUSD.getExpenditureExchangeRate());

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

        bankAPI.setExchangeRate(expenditureEUR);

        System.out.println("Expenditure Exchange Rate (EUR): " + expenditureEUR.getExpenditureExchangeRate());
    }
}
