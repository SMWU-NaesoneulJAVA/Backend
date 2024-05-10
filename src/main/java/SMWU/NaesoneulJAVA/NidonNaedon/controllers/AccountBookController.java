package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import SMWU.NaesoneulJAVA.NidonNaedon.models.AccountBook;
import SMWU.NaesoneulJAVA.NidonNaedon.services.AccountBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountBookController {
    private final AccountBookService accountBookService;

    @Autowired
    public AccountBookController(AccountBookService accountBookService) {
        this.accountBookService = accountBookService;
    }

    @GetMapping("/accountbook/{accountId}")
    public AccountBook getAccountBook(@PathVariable("accountId") String accountId) {
        return accountBookService.getAccountBookByAccountId(accountId);
    }
}
