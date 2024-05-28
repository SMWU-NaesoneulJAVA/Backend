package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import SMWU.NaesoneulJAVA.NidonNaedon.services.KakaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kakao")
@Tag(name = "Kakao", description = "카카오톡 메시지 전송 API")
public class KakaoController {

    @Autowired
    private KakaoService kakaoService;

    @PostMapping("/send-message")
    @Operation(summary = "카카오톡 메시지 전송", description = "카카오톡 메시지를 전송합니다.")
    public ResponseEntity<String> sendMessage(@RequestParam String accessToken,
                                              @RequestParam String accountId) {
        String message = "초대 메시지 내용";
        String link = "https://nidonnaedon.com/invite?accountId=" + accountId;
        return kakaoService.sendKakaoMessage(accessToken, message, link, link);
    }
}
