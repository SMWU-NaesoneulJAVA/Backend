package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.models.AccountBook;

public interface AccountBookService {
    AccountBook getAccountBookByAccountId(String accountId);
    AccountBook createAccountBook(AccountBook accountBook);
    AccountBook updateAccountBook(Long id, AccountBook accountBook);
    boolean deleteAccountBook(Long id);
}
