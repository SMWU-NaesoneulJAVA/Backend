package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.AccountDTO;
import SMWU.NaesoneulJAVA.NidonNaedon.models.Account;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    // UUID 생성
    UUID accountId = UUID.randomUUID();

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    private AccountDTO convertToDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(account.getAccountId());
        accountDTO.setAccountName(account.getAccountName());
        accountDTO.setAccountSchedule(account.getAccountSchedule());
        accountDTO.setAccountCurrency(account.getAccountCurrency());
        accountDTO.setAccountExchangeRate(account.getAccountExchangeRate());
        accountDTO.setAccountParticipantList(account.getAccountParticipantList());
        return accountDTO;
    }

    private Account convertToEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setAccountId(accountDTO.getAccountId());
        account.setAccountName(accountDTO.getAccountName());
        account.setAccountSchedule(accountDTO.getAccountSchedule());
        account.setAccountCurrency(accountDTO.getAccountCurrency());
        account.setAccountExchangeRate(accountDTO.getAccountExchangeRate());
        account.setAccountParticipantList(accountDTO.getAccountParticipantList());
        return account;
    }

    @Test
    public void testCreateAccount() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(accountId.toString());
        accountDTO.setAccountName("Test Account");
        accountDTO.setAccountSchedule("2024-05-08~2024-05-08");
        accountDTO.setAccountCurrency("USD");
        accountDTO.setAccountExchangeRate(1000.0);
        accountDTO.setAccountParticipantList(List.of("Participant1", "Participant2"));

        Account account = convertToEntity(accountDTO);

        when(accountRepository.save(any(Account.class))).thenReturn(account);

        AccountDTO createdAccount = accountService.createAccount(accountDTO);

        assertNotNull(createdAccount);
        System.out.println("accountId: " + createdAccount.getAccountId());
        assertEquals("Test Account", createdAccount.getAccountName());
        assertEquals("2024-05-08~2024-05-08", createdAccount.getAccountSchedule());
        assertEquals("USD", createdAccount.getAccountCurrency());
        assertEquals(1000.0, createdAccount.getAccountExchangeRate());
        assertEquals(List.of("Participant1", "Participant2"), createdAccount.getAccountParticipantList());

        verify(accountRepository, times(1)).save(any(Account.class));
    }
}
