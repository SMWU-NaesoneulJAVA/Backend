package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.AccountDTO;
import SMWU.NaesoneulJAVA.NidonNaedon.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Tag(name = "Account", description = "계정 관련 API")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @Operation(summary = "계정 생성", description = "새로운 계정을 생성합니다.")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO, @RequestParam("userId") String userId) {
        AccountDTO newAccountDTO = accountService.createAccount(accountDTO, userId);
        return new ResponseEntity<>(newAccountDTO, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "모든 계정 조회", description = "모든 계정을 조회합니다.")
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        logger.debug("GET /accounts 호출됨");
        List<AccountDTO> accounts = accountService.getAllAccounts();
        logger.debug("GET /accounts 응답: {}", accounts);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
