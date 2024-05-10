package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.models.AccountBook;

public interface AccountBookService {
    AccountBook getAccountBookByAccountId(String accountId);
}
