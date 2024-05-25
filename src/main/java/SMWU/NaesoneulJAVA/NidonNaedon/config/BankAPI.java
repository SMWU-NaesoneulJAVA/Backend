package SMWU.NaesoneulJAVA.NidonNaedon.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import SMWU.NaesoneulJAVA.NidonNaedon.models.ExchangeRate;
import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.ExchangeRateRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAPI {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    private static final String AUTH_KEY = "nxSyzSsoHPIAFRYMF0hWei14HrXlCg5b";
    private static final String API_URL = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";

    public void setExchangeRate(ExpenditureDetails expenditure) {
        try {
            String searchDate = expenditure.getExpenditureDate();
            String expenditureCurrency = expenditure.getExpenditureCurrency();

            LocalDate date = LocalDate.parse(searchDate, DateTimeFormatter.BASIC_ISO_DATE);
            LocalDate today = LocalDate.now();

            if (date.isAfter(today)) {
                date = today;
            }

            Optional<ExchangeRate> optionalExchangeRate = exchangeRateRepository.findByCurrencyAndDate(expenditureCurrency, date.toString());
            if (optionalExchangeRate.isPresent()) {
                expenditure.setExpenditureExchangeRate(optionalExchangeRate.get().getRate());
                return;
            }

            Double exchangeRate = null;

            while (exchangeRate == null) {
                String apiUrl = API_URL + "?authkey=" + AUTH_KEY + "&searchdate=" + date.format(DateTimeFormatter.BASIC_ISO_DATE) + "&data=AP01";

                URL url = new URL(apiUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String response = br.readLine();
                br.close();

                JSONArray jsonArray = new JSONArray(response);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String curUnit = jsonObject.getString("cur_unit");
                    if (curUnit.equals(expenditureCurrency)) {
                        String exchangeRateStr = jsonObject.getString("deal_bas_r").replace(",", "");
                        exchangeRate = Double.parseDouble(exchangeRateStr);

                        ExchangeRate newRate = new ExchangeRate();
                        newRate.setCurrency(expenditureCurrency);
                        newRate.setDate(date.toString());
                        newRate.setRate(exchangeRate);
                        exchangeRateRepository.save(newRate);

                        break;
                    }
                }

                if (exchangeRate == null) {
                    date = date.minusDays(1);
                }
            }

            expenditure.setExpenditureExchangeRate(exchangeRate);
        } catch (Exception e) {
            e.printStackTrace();
            expenditure.setExpenditureExchangeRate(-1.0);
        }
    }
}
