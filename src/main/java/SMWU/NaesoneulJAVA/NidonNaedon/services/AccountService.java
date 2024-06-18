package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.AccountDTO;

public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO, String userId);
}
