package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.AccountBookDTO;
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
    public AccountBookDTO getAccountBookByAccountId(String accountId) {
        AccountBook accountBook = accountBookRepository.findByAccountId(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("AccountBook not found with id: " + accountId));
        return convertToDTO(accountBook);
    }

    @Override
    @Transactional
    public AccountBookDTO createAccountBook(AccountBookDTO accountBookDTO) {
        AccountBook accountBook = convertToEntity(accountBookDTO);
        AccountBook savedAccountBook = accountBookRepository.save(accountBook);
        return convertToDTO(savedAccountBook);
    }

    @Override
    @Transactional
    public AccountBookDTO updateAccountBook(Long id, AccountBookDTO accountBookDTO) {
        if (accountBookRepository.existsById(id)) {
            AccountBook accountBook = convertToEntity(accountBookDTO);
            accountBook.setId(id);
            AccountBook updatedAccountBook = accountBookRepository.save(accountBook);
            return convertToDTO(updatedAccountBook);
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

    private AccountBookDTO convertToDTO(AccountBook accountBook) {
        AccountBookDTO accountBookDTO = new AccountBookDTO();
        accountBookDTO.setId(accountBook.getId());
        accountBookDTO.setAccountId(accountBook.getAccountId());
        accountBookDTO.setExpenditureList(accountBook.getExpenditureList());
        return accountBookDTO;
    }

    private AccountBook convertToEntity(AccountBookDTO accountBookDTO) {
        AccountBook accountBook = new AccountBook();
        accountBook.setAccountId(accountBookDTO.getAccountId());
        accountBook.setExpenditureList(accountBookDTO.getExpenditureList());
        return accountBook;
    }
}
