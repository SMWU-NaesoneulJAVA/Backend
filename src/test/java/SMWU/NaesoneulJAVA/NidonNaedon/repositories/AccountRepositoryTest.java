package SMWU.NaesoneulJAVA.NidonNaedon.repositories;

import SMWU.NaesoneulJAVA.NidonNaedon.models.Account;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@EntityScan(basePackages = "SMWU.NaesoneulJAVA.NidonNaedon.models")
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @AfterEach
    public void cleanup() {
        // 테스트 데이터 정리
        accountRepository.deleteAll();
    }

    @Test
    @Rollback(false)
    public void testCreateAccount() {
        Account account = new Account();
        account.setAccountId("test-id");
        account.setAccountName("Test Account");
        account.setAccountCurrency("USD");

        accountRepository.save(account);

        Optional<Account> foundAccount = accountRepository.findById("test-id");
        assertThat(foundAccount).isPresent();
        assertThat(foundAccount.get().getAccountName()).isEqualTo("Test Account");
    }
}
