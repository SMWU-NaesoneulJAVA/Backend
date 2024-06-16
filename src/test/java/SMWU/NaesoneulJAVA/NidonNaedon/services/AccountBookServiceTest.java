package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.AccountBookDTO;
import SMWU.NaesoneulJAVA.NidonNaedon.exceptions.ResourceNotFoundException;
import SMWU.NaesoneulJAVA.NidonNaedon.models.AccountBook;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.AccountBookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountBookServiceTest {

    @Mock
    private AccountBookRepository accountBookRepository;

    @InjectMocks
    private AccountBookServiceImpl accountBookService;

    private AccountBookDTO convertToDTO(AccountBook accountBook) {
        AccountBookDTO accountBookDTO = new AccountBookDTO();
        accountBookDTO.setId(accountBook.getId());
        accountBookDTO.setAccountId(accountBook.getAccountId());
        accountBookDTO.setExpenditureList(accountBook.getExpenditureList());
        return accountBookDTO;
    }

    private AccountBook convertToEntity(AccountBookDTO accountBookDTO) {
        AccountBook accountBook = new AccountBook();
        accountBook.setId(accountBookDTO.getId());
        accountBook.setAccountId(accountBookDTO.getAccountId());
        accountBook.setExpenditureList(accountBookDTO.getExpenditureList());
        return accountBook;
    }

    @Test
    void testGetAccountBookByAccountId() {
        String accountId = "testAccountId";
        AccountBook accountBook = new AccountBook();
        accountBook.setAccountId(accountId);

        when(accountBookRepository.findByAccountId(accountId)).thenReturn(Optional.of(accountBook));

        AccountBookDTO result = accountBookService.getAccountBookByAccountId(accountId);

        assertNotNull(result);
        assertEquals(accountId, result.getAccountId());
    }

    @Test
    void testCreateAccountBook() {
        AccountBookDTO accountBookDTO = new AccountBookDTO();
        accountBookDTO.setAccountId("testAccountId");

        AccountBook accountBook = convertToEntity(accountBookDTO);

        when(accountBookRepository.save(any(AccountBook.class))).thenReturn(accountBook);

        AccountBookDTO result = accountBookService.createAccountBook(accountBookDTO);

        assertNotNull(result);
        assertEquals("testAccountId", result.getAccountId());
    }

    @Test
    void testUpdateAccountBook() {
        Long id = 1L;
        AccountBookDTO accountBookDTO = new AccountBookDTO();
        accountBookDTO.setId(id);
        accountBookDTO.setAccountId("testAccountId");

        AccountBook accountBook = convertToEntity(accountBookDTO);

        when(accountBookRepository.existsById(id)).thenReturn(true);
        when(accountBookRepository.save(any(AccountBook.class))).thenReturn(accountBook);

        AccountBookDTO result = accountBookService.updateAccountBook(id, accountBookDTO);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void testUpdateAccountBook_NotFound() {
        Long id = 1L;
        AccountBookDTO accountBookDTO = new AccountBookDTO();
        accountBookDTO.setId(id);
        accountBookDTO.setAccountId("testAccountId");

        when(accountBookRepository.existsById(id)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> accountBookService.updateAccountBook(id, accountBookDTO));
    }

    @Test
    void testDeleteAccountBook() {
        Long id = 1L;

        when(accountBookRepository.existsById(id)).thenReturn(true);
        doNothing().when(accountBookRepository).deleteById(id);

        boolean result = accountBookService.deleteAccountBook(id);

        assertTrue(result);
        verify(accountBookRepository, times(1)).deleteById(id);
    }

    @Test
    void testDeleteAccountBook_NotFound() {
        Long id = 1L;

        when(accountBookRepository.existsById(id)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> accountBookService.deleteAccountBook(id));
    }
}
