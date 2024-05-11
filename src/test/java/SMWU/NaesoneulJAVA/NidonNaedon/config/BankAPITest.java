package SMWU.NaesoneulJAVA.NidonNaedon.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class BankAPITest {

    public static void main(String[] args) {
        testUSDRequest();
        testEURRequest();
    }

    private static void testUSDRequest() {
        String authKey = "nxSyzSsoHPIAFRYMF0hWei14HrXlCg5b";
        String data = "AP01";
        String currency = "USD";
        String date = "20240501";

        // API 요청 URL 조합
        String apiUrl = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON"
                + "?authkey=" + authKey
                + "&searchdate=" + date
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
            System.out.println("Response from API (USD - 20240501): " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testEURRequest() {
        String authKey = "nxSyzSsoHPIAFRYMF0hWei14HrXlCg5b";
        String data = "AP01";
        String currency = "EUR";
        String date = "20240301";

        // API 요청 URL 조합
        String apiUrl = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON"
                + "?authkey=" + authKey
                + "&searchdate=" + date
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
            System.out.println("Response from API (EUR - 20240301): " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
