package SMWU.NaesoneulJAVA.NidonNaedon.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;

public class BankAPI {
    private static final Logger logger = LoggerFactory.getLogger(BankAPI.class);
    private static final String AUTH_KEY = "nxSyzSsoHPIAFRYMF0hWei14HrXlCg5b";
    private static final String API_URL = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";

    public static void setExchangeRate(ExpenditureDetails expenditure) {
        try {
            String searchDate = expenditure.getExpenditureDate();
            String expenditureCurrency = expenditure.getExpenditureCurrency();

            LocalDate date = LocalDate.parse(searchDate, DateTimeFormatter.BASIC_ISO_DATE);
            LocalDate today = LocalDate.now();

            if (date.isAfter(today)) {
                date = today;
            }

            Double exchangeRate = null;
            LocalDate originalDate = date;

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
                        break;
                    }
                }

                if (exchangeRate == null) {
                    date = date.minusDays(1);
                }
            }

            expenditure.setExpenditureExchangeRate(exchangeRate);
        } catch (IOException e) {
            logger.error("IO Exception while fetching exchange rate: ", e);
        } catch (DateTimeParseException e) {
            logger.error("DateTime Parse Exception while parsing date: ", e);
        } catch (Exception e) {
            logger.error("Unexpected Exception: ", e);
            expenditure.setExpenditureExchangeRate(-1.0);
            System.out.println("Error occurred while fetching exchange rate for " + expenditure.getExpenditureCurrency());
        }
    }
}