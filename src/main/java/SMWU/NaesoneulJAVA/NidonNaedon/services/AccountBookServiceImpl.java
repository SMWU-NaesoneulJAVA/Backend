package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.exceptions.ResourceNotFoundException;
import SMWU.NaesoneulJAVA.NidonNaedon.models.AccountBook;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.AccountBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountBookServiceImpl implements AccountBookService {
    private final AccountBookRepository accountBookRepository;

    @Autowired
    public AccountBookServiceImpl(AccountBookRepository accountBookRepository) {
        this.accountBookRepository = accountBookRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public AccountBook getAccountBookByAccountId(String accountId) {
        return accountBookRepository.findByAccountId(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("AccountBook not found with id: " + accountId));
    }

    @Override
    @Transactional
    public AccountBook createAccountBook(AccountBook accountBook) {
        return accountBookRepository.save(accountBook);
    }

    @Override
    @Transactional
    public AccountBook updateAccountBook(Long id, AccountBook accountBook) {
        if (accountBookRepository.existsById(id)) {
            accountBook.setId(id);
            return accountBookRepository.save(accountBook);
        } else {
            throw new ResourceNotFoundException("AccountBook not found with id: " + id);
        }
    }

    @Override
    @Transactional
    public boolean deleteAccountBook(Long id) {
        if (accountBookRepository.existsById(id)) {
            accountBookRepository.deleteById(id);
            return true;
        } else {
            throw new ResourceNotFoundException("AccountBook not found with id: " + id);
        }
    }
}
