package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.models.Account;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        //UUID 생성
        UUID accountId = UUID.randomUUID();

        //새 계좌에 UUID 설정
        account.setAccountId("ai/"+accountId.toString());
        return accountRepository.save(account);
    }
}
