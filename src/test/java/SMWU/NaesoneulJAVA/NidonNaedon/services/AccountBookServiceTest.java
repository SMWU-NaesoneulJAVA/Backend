package SMWU.NaesoneulJAVA.NidonNaedon.services;

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

    @Test
    void testGetAccountBookByAccountId() {
        String accountId = "testAccountId";
        AccountBook accountBook = new AccountBook();
        accountBook.setAccountId(accountId);

        when(accountBookRepository.findByAccountId(accountId)).thenReturn(Optional.of(accountBook));

        AccountBook result = accountBookService.getAccountBookByAccountId(accountId);

        assertNotNull(result);
        assertEquals(accountId, result.getAccountId());
    }

    @Test
    void testCreateAccountBook() {
        AccountBook accountBook = new AccountBook();
        accountBook.setAccountId("testAccountId");

        when(accountBookRepository.save(accountBook)).thenReturn(accountBook);

        AccountBook result = accountBookService.createAccountBook(accountBook);

        assertNotNull(result);
        assertEquals("testAccountId", result.getAccountId());
    }

    @Test
    void testUpdateAccountBook() {
        Long id = 1L;
        AccountBook accountBook = new AccountBook();
        accountBook.setId(id);
        accountBook.setAccountId("testAccountId");

        when(accountBookRepository.existsById(id)).thenReturn(true);
        when(accountBookRepository.save(accountBook)).thenReturn(accountBook);

        AccountBook result = accountBookService.updateAccountBook(id, accountBook);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void testUpdateAccountBook_NotFound() {
        Long id = 1L;
        AccountBook accountBook = new AccountBook();
        accountBook.setId(id);
        accountBook.setAccountId("testAccountId");

        when(accountBookRepository.existsById(id)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> accountBookService.updateAccountBook(id, accountBook));
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
