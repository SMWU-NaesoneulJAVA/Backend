package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.models.AccountBook;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.AccountBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountBookServiceImpl implements AccountBookService {
    private final AccountBookRepository accountBookRepository;

    @Autowired
    public AccountBookServiceImpl(AccountBookRepository accountBookRepository) {
        this.accountBookRepository = accountBookRepository;
    }

    @Override
    public AccountBook getAccountBookByAccountId(String accountId) {
        return accountBookRepository.findByAccountId(accountId);
    }
}