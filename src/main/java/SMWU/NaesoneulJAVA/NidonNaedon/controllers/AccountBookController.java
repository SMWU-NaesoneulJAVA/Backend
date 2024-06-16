package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.AccountBookDTO;
import SMWU.NaesoneulJAVA.NidonNaedon.exceptions.ResourceNotFoundException;
import SMWU.NaesoneulJAVA.NidonNaedon.services.AccountBookService;
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

    @Autowired
    public AccountBookController(AccountBookService accountBookService) {
        this.accountBookService = accountBookService;
    }

    @GetMapping("/{accountId}")
    @Operation(summary = "계정 장부 조회", description = "주어진 계정 ID로 가계부를 조회합니다.")
    public ResponseEntity<AccountBookDTO> getAccountBook(@PathVariable("accountId") String accountId) {
        try {
            AccountBookDTO accountBookDTO = accountBookService.getAccountBookByAccountId(accountId);
            return new ResponseEntity<>(accountBookDTO, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @Operation(summary = "가계부 생성", description = "새로운 가계부를 생성합니다.")
    public ResponseEntity<AccountBookDTO> createAccountBook(@Valid @RequestBody AccountBookDTO accountBookDTO) {
        AccountBookDTO newAccountBookDTO = accountBookService.createAccountBook(accountBookDTO);
        return new ResponseEntity<>(newAccountBookDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "가계부 수정", description = "주어진 ID로 가계부를 수정합니다.")
    public ResponseEntity<AccountBookDTO> updateAccountBook(@PathVariable("id") Long id, @Valid @RequestBody AccountBookDTO accountBookDTO) {
        AccountBookDTO updatedAccountBookDTO = accountBookService.updateAccountBook(id, accountBookDTO);
        if (updatedAccountBookDTO != null) {
            return new ResponseEntity<>(updatedAccountBookDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "가계부 삭제", description = "주어진 ID로 가계부를 삭제합니다.")
    public ResponseEntity<Void> deleteAccountBook(@PathVariable("id") Long id) {
        boolean isDeleted = accountBookService.deleteAccountBook(id);
        return new ResponseEntity<>(isDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }
}
