package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import SMWU.NaesoneulJAVA.NidonNaedon.models.AccountBook;
import SMWU.NaesoneulJAVA.NidonNaedon.services.AccountBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/accountbook")
public class AccountBookController {
    private final AccountBookService accountBookService;

    @Autowired
    public AccountBookController(AccountBookService accountBookService) {
        this.accountBookService = accountBookService;
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountBook> getAccountBook(@PathVariable("accountId") String accountId) {
        AccountBook accountBook = accountBookService.getAccountBookByAccountId(accountId);
        if (accountBook != null) {
            return new ResponseEntity<>(accountBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AccountBook> createAccountBook(@Valid @RequestBody AccountBook accountBook) {
        AccountBook newAccountBook = accountBookService.createAccountBook(accountBook);
        return new ResponseEntity<>(newAccountBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountBook> updateAccountBook(@PathVariable("id") Long id, @Valid @RequestBody AccountBook accountBook) {
        AccountBook updatedAccountBook = accountBookService.updateAccountBook(id, accountBook);
        if (updatedAccountBook != null) {
            return new ResponseEntity<>(updatedAccountBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountBook(@PathVariable("id") Long id) {
        boolean isDeleted = accountBookService.deleteAccountBook(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
