package SMWU.NaesoneulJAVA.NidonNaedon.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import SMWU.NaesoneulJAVA.NidonNaedon.models.ExpenditureDetails;
import org.json.JSONArray;
import org.json.JSONObject;

public class BankAPI {

    public static void main(String[] args) {
        String authKey = "nxSyzSsoHPIAFRYMF0hWei14HrXlCg5b";
        String data = "AP01";

        ExpenditureDetails expenditureDetails = new ExpenditureDetails(null, null, 0, null, 0, null, null, null);
        String expenditureDate = expenditureDetails.getExpenditureDate();

        // API 요청 URL 조합
        String apiUrl = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON"
                + "?authkey=" + authKey
                + "&searchdate=" + expenditureDate // expenditureDate로 변경
                + "&data=" + data;

        try {
            // API에 HTTP 요청 보내기
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // 응답 받기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            // 응답 결과 확인
            System.out.println("Response from API: " + response.toString());

            // JSON 파싱하여 DEAL_BAS_R 값을 추출하여 ExpenditureDetails 클래스에 대입
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray exchangeList = jsonResponse.getJSONArray("list");
            if (exchangeList.length() > 0) {
                JSONObject exchangeData = exchangeList.getJSONObject(0);
                double exchangeRate = exchangeData.getDouble("DEAL_BAS_R");
                expenditureDetails.setExpenditureExchangeRate(exchangeRate);
                System.out.println("Exchange Rate: " + exchangeRate);
            } else {
                System.out.println("No exchange rate data found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

