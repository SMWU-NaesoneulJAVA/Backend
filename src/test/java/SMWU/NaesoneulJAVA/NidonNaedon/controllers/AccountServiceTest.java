package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import SMWU.NaesoneulJAVA.NidonNaedon.models.Account;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.AccountRepository;
import SMWU.NaesoneulJAVA.NidonNaedon.services.AccountService;
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
    //UUID 생성
    UUID accountId = UUID.randomUUID();

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void testCreateAccount() {
        Account account = new Account();
        account.setAccountId(accountId.toString()); // 이전에 생성한 UUID로 accountId 설정
        account.setAccountName("Test Account");
        account.setAccountSchedule("2024-05-08~2024-05-08");
        account.setAccountCurrency("USD");
        account.setAccountExchangeRate(1000.0);
        account.setAccountParticipantList(List.of("Participant1", "Participant2"));

        when(accountRepository.save(any(Account.class))).thenReturn(account);

        Account createdAccount = accountService.createAccount(account);

        assertNotNull(createdAccount);
        System.out.println("accountId: "+createdAccount.getAccountId());    //테스트 별로 값 다른 거 확인
        assertEquals("Test Account", createdAccount.getAccountName());
        assertEquals("2024-05-08~2024-05-08", createdAccount.getAccountSchedule());
        assertEquals("USD", createdAccount.getAccountCurrency());
        assertEquals(1000.0, createdAccount.getAccountExchangeRate());
        assertEquals(List.of("Participant1", "Participant2"), createdAccount.getAccountParticipantList());

        verify(accountRepository, times(1)).save(any(Account.class));
    }
}