package SMWU.NaesoneulJAVA.NidonNaedon.repositories;

import SMWU.NaesoneulJAVA.NidonNaedon.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByKakaoId(String kakaoId);
}
