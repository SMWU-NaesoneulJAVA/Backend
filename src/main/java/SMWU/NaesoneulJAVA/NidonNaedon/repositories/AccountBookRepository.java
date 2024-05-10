package SMWU.NaesoneulJAVA.NidonNaedon.repositories;

import SMWU.NaesoneulJAVA.NidonNaedon.models.AccountBook;

public interface AccountBookRepository {
    AccountBook findByAccountId(String accountId);
}
