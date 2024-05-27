package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import SMWU.NaesoneulJAVA.NidonNaedon.exceptions.ResourceNotFoundException;
import SMWU.NaesoneulJAVA.NidonNaedon.models.AccountBook;
import SMWU.NaesoneulJAVA.NidonNaedon.services.AccountBookService;
import SMWU.NaesoneulJAVA.NidonNaedon.services.InvitationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accountbook")
@Tag(name = "AccountBook", description = "가계부 관련 API")
public class AccountBookController {
    private final AccountBookService accountBookService;
    private final InvitationService invitationService;

    @Autowired
    public AccountBookController(AccountBookService accountBookService, InvitationService invitationService) {
        this.accountBookService = accountBookService;
        this.invitationService = invitationService;
    }

    @GetMapping("/{accountId}")
    @Operation(summary = "계정 장부 조회", description = "주어진 계정 ID로 가계부를 조회합니다.")
    public ResponseEntity<AccountBook> getAccountBook(@PathVariable("accountId") String accountId) {
        try {
            System.out.println("Request received for accountId: " + accountId); // 디버깅 로그
            AccountBook accountBook = accountBookService.getAccountBookByAccountId(accountId);
            return new ResponseEntity<>(accountBook, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace(); // 디버깅 로그
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace(); // 디버깅 로그
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @Operation(summary = "가계부 생성", description = "새로운 가계부를 생성합니다.")
    public ResponseEntity<AccountBook> createAccountBook(@Valid @RequestBody AccountBook accountBook) {
        AccountBook newAccountBook = accountBookService.createAccountBook(accountBook);
        return new ResponseEntity<>(newAccountBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "가계부 수정", description = "주어진 ID로 가계부를 수정합니다.")
    public ResponseEntity<AccountBook> updateAccountBook(@PathVariable("id") Long id, @Valid @RequestBody AccountBook accountBook) {
        AccountBook updatedAccountBook = accountBookService.updateAccountBook(id, accountBook);
        if (updatedAccountBook != null) {
            return new ResponseEntity<>(updatedAccountBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "가계부 삭제", description = "주어진 ID로 가계부를 삭제합니다.")
    public ResponseEntity<Void> deleteAccountBook(@PathVariable("id") Long id) {
        boolean isDeleted = accountBookService.deleteAccountBook(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{accountId}/invite")
    @Operation(summary = "참여자 초대", description = "주어진 가계부 ID로 참여자를 초대합니다.")
    public ResponseEntity<String> inviteParticipant(@PathVariable("accountId") String accountId) {
        String invitationLink = invitationService.generateInvitationLink(accountId);
        invitationService.sendKakaoInvitation(invitationLink);
        return new ResponseEntity<>("Invitation sent successfully via KakaoTalk", HttpStatus.OK);
    }
}
