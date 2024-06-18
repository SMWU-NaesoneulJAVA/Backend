package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.AccountDTO;
import SMWU.NaesoneulJAVA.NidonNaedon.models.Account;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO, String userId) {
        Account account = convertToEntity(accountDTO);
        // UUID accountId = UUID.randomUUID();
        // account.setAccountId("ai" + accountId.toString()); // 이 부분은 주석 처리
        List<String> participants = account.getAccountParticipantList();
        participants.add(userId);  // 본인을 참여자에 자동 추가
        account.setAccountParticipantList(participants);
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
