package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import SMWU.NaesoneulJAVA.NidonNaedon.services.InvitationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accountbook")
@Tag(name = "AccountBook", description = "가계부 관련 API")
public class AccountBookController {
    private final InvitationService invitationService;

    @Autowired
    public AccountBookController(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @PostMapping("/{accountId}/invite")
    @Operation(summary = "참여자 초대", description = "주어진 가계부 ID로 참여자를 초대합니다.")
    public ResponseEntity<String> inviteParticipant(@PathVariable("accountId") String accountId,
                                                    @RequestParam String accessToken) {
        String invitationLink = invitationService.generateInvitationLink(accountId);
        invitationService.sendKakaoInvitation(accessToken, invitationLink);
        return new ResponseEntity<>("Invitation sent successfully via KakaoTalk", HttpStatus.OK);
    }

    @GetMapping("/invite")
    @Operation(summary = "초대 링크 처리", description = "초대 링크를 통해 참여자를 추가합니다.")
    public ResponseEntity<String> handleInvitation(@RequestParam String accountId,
                                                   @RequestParam String participant) {
        boolean added = invitationService.addParticipant(accountId, participant);
        if (added) {
            return new ResponseEntity<>("Participant added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("AccountBook not found", HttpStatus.NOT_FOUND);
        }
    }
}
