package SMWU.NaesoneulJAVA.NidonNaedon.services;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class KakaoService {

    private static final String KAKAO_MESSAGE_URL = "https://kapi.kakao.com/v2/api/talk/memo/default/send";
    private static final String REST_API_KEY = "4e4a5f24acd40618c0b9d38377260bc8";

    public ResponseEntity<String> sendKakaoMessage(String accessToken, String message, String webUrl, String mobileWebUrl) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, Object> linkObject = new HashMap<>();
            linkObject.put("web_url", webUrl);
            linkObject.put("mobile_web_url", mobileWebUrl);

            Map<String, Object> templateObject = new HashMap<>();
            templateObject.put("object_type", "text");
            templateObject.put("text", message);
            templateObject.put("link", linkObject);
            templateObject.put("button_title", "바로 확인");

            Map<String, Object> body = new HashMap<>();
            body.put("template_object", templateObject);

            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(KAKAO_MESSAGE_URL, requestEntity, String.class);
            return response;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
