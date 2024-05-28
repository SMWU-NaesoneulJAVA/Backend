package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.AccountBookDTO;

public interface AccountBookService {
    AccountBookDTO getAccountBookByAccountId(String accountId);
    AccountBookDTO createAccountBook(AccountBookDTO accountBookDTO);
    AccountBookDTO updateAccountBook(Long id, AccountBookDTO accountBookDTO);
    boolean deleteAccountBook(Long id);
}
