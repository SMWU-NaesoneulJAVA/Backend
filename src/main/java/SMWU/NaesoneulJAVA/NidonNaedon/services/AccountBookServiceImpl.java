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

    @Override
    public AccountBook createAccountBook(AccountBook accountBook) {
        return accountBookRepository.save(accountBook);
    }

    @Override
    public AccountBook updateAccountBook(Long id, AccountBook accountBook) {
        if (accountBookRepository.existsById(id)) {
            accountBook.setId(id);
            return accountBookRepository.save(accountBook);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteAccountBook(Long id) {
        if (accountBookRepository.existsById(id)) {
            accountBookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
