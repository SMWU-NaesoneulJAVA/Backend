package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.models.AccountBook;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.AccountBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InvitationService {

    @Autowired
    private KakaoService kakaoService;

    @Autowired
    private AccountBookRepository accountBookRepository;

    public String generateInvitationLink(String accountId) {
        String invitationCode = UUID.randomUUID().toString();
        return "https://nidonnaedon.com/invite?accountId=" + accountId;
    }

    public void sendKakaoInvitation(String accessToken, String link) {
        String message = "초대 메시지 내용";
        String webUrl = link;
        String mobileWebUrl = link;

        kakaoService.sendKakaoMessage(accessToken, message, webUrl, mobileWebUrl);
    }

    public boolean addParticipant(String accountId, String participant) {
        AccountBook accountBook = accountBookRepository.findByAccountId(accountId).orElse(null);
        if (accountBook != null) {
            accountBook.getExpenditureList().add(participant);
            accountBookRepository.save(accountBook);
            return true;
        }
        return false;
    }
}
