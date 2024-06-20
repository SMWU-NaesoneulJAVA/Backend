package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.AccountDTO;

import java.util.List;

public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO, String userId);
    List<AccountDTO> getAllAccounts();
    boolean deleteAccount(String accountId);
}
