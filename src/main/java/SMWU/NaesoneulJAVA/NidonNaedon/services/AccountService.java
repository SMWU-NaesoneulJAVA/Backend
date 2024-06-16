package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.AccountDTO;
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
    

    
    public Account findByKakaoId(String kakaoId) {
        return accountRepository.findByKakaoId(kakaoId);
    }

    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = convertToEntity(accountDTO);
        UUID accountId = UUID.randomUUID();
        account.setAccountId("ai" + accountId.toString());
        Account savedAccount = accountRepository.save(account);
        return convertToDTO(savedAccount);
    }

    private Account convertToEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setAccountName(accountDTO.getAccountName());
        account.setAccountSchedule(accountDTO.getAccountSchedule());
        account.setAccountCurrency(accountDTO.getAccountCurrency());
        account.setAccountExchangeRate(accountDTO.getAccountExchangeRate());
        account.setAccountParticipantList(accountDTO.getAccountParticipantList());
        return account;
    }

    private AccountDTO convertToDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(account.getAccountId());
        accountDTO.setAccountName(account.getAccountName());
        accountDTO.setAccountSchedule(account.getAccountSchedule());
        accountDTO.setAccountCurrency(account.getAccountCurrency());
        accountDTO.setAccountExchangeRate(account.getAccountExchangeRate());
        accountDTO.setAccountParticipantList(account.getAccountParticipantList());
        return accountDTO;
    }
}
