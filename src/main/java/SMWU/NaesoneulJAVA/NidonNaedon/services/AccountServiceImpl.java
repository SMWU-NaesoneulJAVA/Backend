package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.AccountDTO;
import SMWU.NaesoneulJAVA.NidonNaedon.models.Account;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO, String userId) {
        Account account = convertToEntity(accountDTO);
        List<String> participants = account.getAccountParticipantList();
        participants.add(userId);  // 본인을 참여자에 자동 추가
        account.setAccountParticipantList(participants);
        Account savedAccount = accountRepository.save(account);
        return convertToDTO(savedAccount);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        logger.debug("Retrieved accounts from DB: {}", accounts);
        return accounts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteAccount(String accountId) {
        return accountRepository.findByAccountId(accountId)
                .map(account -> {
                    accountRepository.delete(account);
                    return true;
                }).orElse(false);
    }

    private Account convertToEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setAccountName(accountDTO.getAccountName() != null ? accountDTO.getAccountName() : "");
        account.setAccountSchedule(accountDTO.getAccountSchedule() != null ? accountDTO.getAccountSchedule() : "");
        account.setAccountCurrency(accountDTO.getAccountCurrency() != null ? accountDTO.getAccountCurrency() : "");
        account.setAccountExchangeRate(accountDTO.getAccountExchangeRate() != null ? accountDTO.getAccountExchangeRate() : 0.0);
        account.setAccountParticipantList(accountDTO.getAccountParticipantList() != null ? accountDTO.getAccountParticipantList() : new ArrayList<>());
        return account;
    }

    private AccountDTO convertToDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(account.getAccountId() != null ? account.getAccountId() : "");
        accountDTO.setAccountName(account.getAccountName() != null ? account.getAccountName() : "");
        accountDTO.setAccountSchedule(account.getAccountSchedule() != null ? account.getAccountSchedule() : "");
        accountDTO.setAccountCurrency(account.getAccountCurrency() != null ? account.getAccountCurrency() : "");
        accountDTO.setAccountExchangeRate(account.getAccountExchangeRate() != null ? account.getAccountExchangeRate() : 0.0);
        accountDTO.setAccountParticipantList(account.getAccountParticipantList() != null ? account.getAccountParticipantList() : new ArrayList<>());
        logger.debug("Converted Account to AccountDTO: {}", accountDTO);
        return accountDTO;
    }
}
