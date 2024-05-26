package SMWU.NaesoneulJAVA.NidonNaedon.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InvitationService {

    public String generateInvitationLink(String accountId) {
        String invitationCode = UUID.randomUUID().toString();
        // Save invitationCode and accountId mapping to database if needed
        return "https://nidonnaedon.com/invite?code=" + invitationCode + "&accountId=" + accountId;
    }

    public void sendKakaoInvitation(String link) {
        // 카카오톡 SDK를 이용하여 메시지 보내기
        // 아래는 예시 코드이며, 실제 구현은 카카오톡 SDK 문서를 참고하여 작성합니다.
        System.out.println("Sending KakaoTalk invitation link: " + link);

        // Implement KakaoTalk API integration to send the message
    }
}
